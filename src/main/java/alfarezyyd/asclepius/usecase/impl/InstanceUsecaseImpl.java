package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.InstanceMapper;
import alfarezyyd.asclepius.model.dto.instance.InstanceCreateRequest;
import alfarezyyd.asclepius.model.dto.instance.InstanceResponse;
import alfarezyyd.asclepius.model.dto.instance.InstanceUpdateRequest;
import alfarezyyd.asclepius.model.entity.Instance;
import alfarezyyd.asclepius.repository.InstanceRepository;
import alfarezyyd.asclepius.usecase.InstanceUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class InstanceUsecaseImpl implements InstanceUsecase {
  private final InstanceRepository instanceRepository;
  private final InstanceMapper instanceMapper;
  private final ValidationUtil validationUtil;

  public InstanceUsecaseImpl(InstanceRepository instanceRepository, InstanceMapper instanceMapper, ValidationUtil validationUtil) {
    this.instanceRepository = instanceRepository;
    this.instanceMapper = instanceMapper;
    this.validationUtil = validationUtil;
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
    instanceRepository.save(newInstance);
  }

  @Override
  public void update(InstanceUpdateRequest instanceUpdateRequest) {
    validationUtil.validateRequest(instanceUpdateRequest);
    Instance instance = instanceRepository.findById(instanceUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "instance not found"));
    instanceMapper.instanceDtoIntoInstanceEntity(instance, instanceUpdateRequest);
    instanceRepository.save(instance);
  }

  @Override
  public void delete(String instanceCode) {
    if (instanceRepository.existsById(instanceCode)) {
      instanceRepository.deleteById(instanceCode);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "instance not found");
    }
  }
}
