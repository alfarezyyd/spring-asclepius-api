package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.InsuranceMapper;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceCreateRequest;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceResponse;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceUpdateRequest;
import alfarezyyd.asclepius.model.entity.Insurance;
import alfarezyyd.asclepius.repository.InsuranceRepository;
import alfarezyyd.asclepius.usecase.InsuranceUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InsuranceUsecaseImpl implements InsuranceUsecase {
  private final InsuranceRepository insuranceRepository;
  private final InsuranceMapper insuranceMapper;
  private final ValidationUtil validationUtil;

  public InsuranceUsecaseImpl(InsuranceRepository insuranceRepository, InsuranceMapper insuranceMapper, ValidationUtil validationUtil) {
    this.insuranceRepository = insuranceRepository;
    this.insuranceMapper = insuranceMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<InsuranceResponse> findAll() {
    return insuranceRepository.findAll().stream().map(insuranceMapper::insuranceEntityIntoInsuranceResponse).toList();
  }

  @Override
  public InsuranceResponse findById(String insuranceCode) {
    Insurance insurance = insuranceRepository.findById(insuranceCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "insurance not found"));
    return insuranceMapper.insuranceEntityIntoDetailInsuranceResponse(insurance);
  }

  @Override
  public void create(InsuranceCreateRequest insuranceCreateRequest) {
    validationUtil.validateRequest(insuranceCreateRequest);
    Insurance newInsurance = new Insurance();
    insuranceMapper.insuranceDtoIntoInsuranceEntity(newInsurance, insuranceCreateRequest);
    insuranceRepository.save(newInsurance);
  }

  @Override
  public void update(InsuranceUpdateRequest insuranceUpdateRequest) {
    validationUtil.validateRequest(insuranceUpdateRequest);
    Insurance insurance = insuranceRepository.findById(insuranceUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "insurance not found"));
    insuranceMapper.insuranceDtoIntoInsuranceEntity(insurance, insuranceUpdateRequest);
    insuranceRepository.save(insurance);
  }

  @Override
  public void delete(String insuranceCode) {
    if (insuranceRepository.existsById(insuranceCode)) {
      insuranceRepository.deleteById(insuranceCode);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "insurance not found");
    }
  }
}
