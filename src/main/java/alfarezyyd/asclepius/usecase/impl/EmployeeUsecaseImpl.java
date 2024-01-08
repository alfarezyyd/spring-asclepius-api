package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.EmployeeMapper;
import alfarezyyd.asclepius.model.dto.employee.EmployeeCreateRequest;
import alfarezyyd.asclepius.model.dto.employee.EmployeeResponse;
import alfarezyyd.asclepius.model.dto.employee.EmployeeUpdateRequest;
import alfarezyyd.asclepius.model.entity.*;
import alfarezyyd.asclepius.repository.EmployeeRepository;
import alfarezyyd.asclepius.repository.PositionRepository;
import alfarezyyd.asclepius.usecase.AddressUsecase;
import alfarezyyd.asclepius.usecase.EmployeeUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeUsecaseImpl implements EmployeeUsecase {
  private final EmployeeRepository employeeRepository;
  private final AddressUsecase addressUsecase;
  private final ValidationUtil validationUtil;
  private final EmployeeMapper employeeMapper;
  private final PositionRepository positionRepository;

  public EmployeeUsecaseImpl(EmployeeRepository employeeRepository, AddressUsecase addressUsecase, ValidationUtil validationUtil, EmployeeMapper employeeMapper, PositionRepository positionRepository) {
    this.employeeRepository = employeeRepository;
    this.addressUsecase = addressUsecase;
    this.validationUtil = validationUtil;
    this.employeeMapper = employeeMapper;
    this.positionRepository = positionRepository;
  }

  @Override
  public List<EmployeeResponse> findAll() {
    return employeeRepository.findAll().stream().map(employeeMapper::employeeEntityIntoEmployeeResponse).toList();
  }

  @Override
  public EmployeeResponse findById(Long personId) {
    Employee searchedEmployee = employeeRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found"));
    return employeeMapper.employeeEntityIntoDetailEmployeeResponse(searchedEmployee);
  }

  @Override
  @Transactional
  public void create(EmployeeCreateRequest employeeCreateRequest) {
    validationUtil.validateRequest(employeeCreateRequest);
    Address address = addressUsecase.create(employeeCreateRequest.getAddress());
    Employee employee = new Employee();
    employee.setAddress(address);
    employeeMapper.employeeDtoIntoEmployeeEntity(employee, employeeCreateRequest);
    Position position = positionRepository.findById(employeeCreateRequest.getPositionCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "position not found"));
    employee.setPosition(position);
    employeeRepository.save(employee);
  }

  @Override
  public void update(EmployeeUpdateRequest employeeUpdateRequest) {
    validationUtil.validateRequest(employeeUpdateRequest);
    Employee searchedEmployee = employeeRepository.findById(employeeUpdateRequest.getPersonId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found"));
    addressUsecase.update(employeeUpdateRequest.getAddress(), searchedEmployee.getAddress());
    employeeMapper.employeeDtoIntoEmployeeEntity(searchedEmployee, employeeUpdateRequest);
    if (employeeUpdateRequest.getPositionCode().equals(searchedEmployee.getPosition().getCode())) {
      Position position = positionRepository.findById(employeeUpdateRequest.getPositionCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "position not found"));
      searchedEmployee.setPosition(position);
    }
    employeeRepository.save(searchedEmployee);

  }

  @Override
  public void delete(Long personId) {
    Employee employee = employeeRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found"));
    employeeRepository.delete(employee);
    addressUsecase.delete(employee.getAddress().getId());
  }
}