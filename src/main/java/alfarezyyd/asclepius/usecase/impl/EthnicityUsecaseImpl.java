package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.EthnicityMapper;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityCreateRequest;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityResponse;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityUpdateRequest;
import alfarezyyd.asclepius.model.entity.Ethnicity;
import alfarezyyd.asclepius.repository.EthnicityRepository;
import alfarezyyd.asclepius.usecase.EthnicityUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EthnicityUsecaseImpl implements EthnicityUsecase {
  private final EthnicityRepository ethnicityRepository;
  private final EthnicityMapper ethnicityMapper;
  private final ValidationUtil validationUtil;

  public EthnicityUsecaseImpl(EthnicityRepository ethnicityRepository, EthnicityMapper ethnicityMapper, ValidationUtil validationUtil) {
    this.ethnicityRepository = ethnicityRepository;
    this.ethnicityMapper = ethnicityMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<EthnicityResponse> findAll() {
    return ethnicityRepository.findAll().stream().map(ethnicityMapper::ethnicityEntityIntoEthnicityResponse).toList();
  }

  @Override
  public EthnicityResponse findById(Short ethnicityId) {
    Ethnicity ethnicity = ethnicityRepository.findById(ethnicityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ethnicity not found"));
    return ethnicityMapper.ethnicityEntityIntoDetailEthnicityResponse(ethnicity);
  }

  @Override
  public void create(EthnicityCreateRequest ethnicityCreateRequest) {
    validationUtil.validateRequest(ethnicityCreateRequest);
    Ethnicity newEthnicity = new Ethnicity();
    ethnicityMapper.ethnicityDtoIntoEthnicityEntity(newEthnicity, ethnicityCreateRequest);
    ethnicityRepository.save(newEthnicity);
  }

  @Override
  public void update(EthnicityUpdateRequest ethnicityUpdateRequest) {
    validationUtil.validateRequest(ethnicityUpdateRequest);
    Ethnicity ethnicity = ethnicityRepository.findById(ethnicityUpdateRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ethnicity not found"));
    ethnicityMapper.ethnicityDtoIntoEthnicityEntity(ethnicity, ethnicityUpdateRequest);
    ethnicityRepository.save(ethnicity);
  }

  @Override
  public void delete(Short ethnicityId) {
    if (ethnicityRepository.existsById(ethnicityId)) {
      ethnicityRepository.deleteById(ethnicityId);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ethnicity not found");
    }
  }
}
