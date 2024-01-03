package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.CustodianMapper;
import alfarezyyd.asclepius.model.dto.custodian.CustodianCreateRequest;
import alfarezyyd.asclepius.model.dto.custodian.CustodianResponse;
import alfarezyyd.asclepius.model.dto.custodian.CustodianUpdateRequest;
import alfarezyyd.asclepius.model.entity.Address;
import alfarezyyd.asclepius.model.entity.Custodian;
import alfarezyyd.asclepius.repository.CustodianRepository;
import alfarezyyd.asclepius.usecase.AddressUsecase;
import alfarezyyd.asclepius.usecase.CustodianUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustodianUsecaseImpl implements CustodianUsecase {
  private final CustodianRepository custodianRepository;
  private final CustodianMapper custodianMapper;
  private final ValidationUtil validationUtil;
  private final AddressUsecase addressUsecase;

  public CustodianUsecaseImpl(CustodianRepository custodianRepository, CustodianMapper custodianMapper, ValidationUtil validationUtil, AddressUsecase addressUsecase) {
    this.custodianRepository = custodianRepository;
    this.custodianMapper = custodianMapper;
    this.validationUtil = validationUtil;
    this.addressUsecase = addressUsecase;
  }

  @Override
  public List<CustodianResponse> findAll() {
    return custodianRepository.findAll().stream().map(custodianMapper::custodianEntityIntoCustodianResponse).toList();
  }

  @Override
  public CustodianResponse findById(Long personId) {
    Custodian custodian = custodianRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "custodian not found"));
    return custodianMapper.custodianEntityIntoDetailCustodianResponse(custodian);
  }

  @Override
  public void create(CustodianCreateRequest custodianCreateRequest) {
    validationUtil.validateRequest(custodianCreateRequest);
    Custodian newCustodian = new Custodian();
    custodianMapper.custodianDtoIntoCustodianEntity(newCustodian, custodianCreateRequest);
    Address address = addressUsecase.create(custodianCreateRequest.getAddress());
    newCustodian.setAddress(address);
    custodianRepository.save(newCustodian);
  }

  @Override
  public void update(CustodianUpdateRequest custodianUpdateRequest) {
    validationUtil.validateRequest(custodianUpdateRequest);
    Custodian custodian = custodianRepository.findById(custodianUpdateRequest.getPersonId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "custodian not found"));
    custodianMapper.custodianDtoIntoCustodianEntity(custodian, custodianUpdateRequest);
    custodianRepository.save(custodian);

  }

  @Override
  public void delete(Long personId) {
    Custodian custodian = custodianRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "custodian not found"));
    custodianRepository.delete(custodian);
    addressUsecase.delete(custodian.getAddress().getId());
  }
}
