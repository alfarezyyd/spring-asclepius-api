package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.InstanceMapper;
import alfarezyyd.asclepius.model.dto.instance.InstanceCreateRequest;
import alfarezyyd.asclepius.model.dto.instance.InstanceResponse;
import alfarezyyd.asclepius.model.dto.instance.InstanceUpdateRequest;
import alfarezyyd.asclepius.model.entity.Address;
import alfarezyyd.asclepius.model.entity.Instance;
import alfarezyyd.asclepius.repository.InstanceRepository;
import alfarezyyd.asclepius.usecase.AddressUsecase;
import alfarezyyd.asclepius.usecase.InstanceUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InstanceUsecaseImpl implements InstanceUsecase {
  private final InstanceRepository instanceRepository;
  private final InstanceMapper instanceMapper;
  private final ValidationUtil validationUtil;
  private final AddressUsecase addressUsecase;

  public InstanceUsecaseImpl(InstanceRepository instanceRepository, InstanceMapper instanceMapper, ValidationUtil validationUtil, AddressUsecase addressUsecase) {
    this.instanceRepository = instanceRepository;
    this.instanceMapper = instanceMapper;
    this.validationUtil = validationUtil;
    this.addressUsecase = addressUsecase;
  }

  @Override
  public List<InstanceResponse> findAll() {
    return instanceRepository.findAll().stream().map(instanceMapper::instanceEntityIntoInstanceResponse).toList();
  }

  @Override
  public InstanceResponse findById(String instanceCode) {
    Instance instance = instanceRepository.findById(instanceCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "instance not found"));
    return instanceMapper.instanceEntityIntoDetailInstanceResponse(instance);
  }

  @Override
  public void create(InstanceCreateRequest instanceCreateRequest) {
    validationUtil.validateRequest(instanceCreateRequest);
    Instance newInstance = new Instance();
    instanceMapper.instanceDtoIntoInstanceEntity(newInstance, instanceCreateRequest);
    Address address = addressUsecase.create(instanceCreateRequest.getAddress());
    newInstance.setAddress(address);
    instanceRepository.save(newInstance);
  }

  @Override
  public void update(InstanceUpdateRequest instanceUpdateRequest) {
    validationUtil.validateRequest(instanceUpdateRequest);
    Instance instance = instanceRepository.findById(instanceUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "instance not found"));
    instanceMapper.instanceDtoIntoInstanceEntity(instance, instanceUpdateRequest);
    addressUsecase.update(instanceUpdateRequest.getAddress(), instance.getAddress());
    instanceRepository.save(instance);
  }

  @Override
  public void delete(String instanceCode) {
    Instance instance = instanceRepository.findById(instanceCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "instance not found"));
    if (!instance.getPatients().isEmpty()){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "there is patients in this instance!");
    }
  }
}
