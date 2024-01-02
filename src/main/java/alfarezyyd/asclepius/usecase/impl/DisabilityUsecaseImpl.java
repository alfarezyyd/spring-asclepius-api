package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.DisabilityMapper;
import alfarezyyd.asclepius.model.dto.disability.DisabilityCreateRequest;
import alfarezyyd.asclepius.model.dto.disability.DisabilityResponse;
import alfarezyyd.asclepius.model.dto.disability.DisabilityUpdateRequest;
import alfarezyyd.asclepius.model.entity.Disability;
import alfarezyyd.asclepius.repository.DisabilityRepository;
import alfarezyyd.asclepius.usecase.DisabilityUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DisabilityUsecaseImpl implements DisabilityUsecase {
  private final DisabilityRepository disabilityRepository;
  private final DisabilityMapper disabilityMapper;
  private final ValidationUtil validationUtil;

  public DisabilityUsecaseImpl(DisabilityRepository disabilityRepository, DisabilityMapper disabilityMapper, ValidationUtil validationUtil) {
    this.disabilityRepository = disabilityRepository;
    this.disabilityMapper = disabilityMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<DisabilityResponse> findAll() {
    return disabilityRepository.findAll().stream().map(disabilityMapper::disabilityEntityIntoDisabilityResponse).toList();
  }

  @Override
  public DisabilityResponse findById(Short disabilityId) {
    Disability disability = disabilityRepository.findById(disabilityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "disability not found"));
    return disabilityMapper.disabilityEntityIntoDetailDisabilityResponse(disability);
  }

  @Override
  public void create(DisabilityCreateRequest disabilityCreateRequest) {
    validationUtil.validateRequest(disabilityCreateRequest);
    Disability newDisability = new Disability();
    disabilityMapper.disabilityDtoIntoDisabilityEntity(newDisability, disabilityCreateRequest);
    disabilityRepository.save(newDisability);
  }

  @Override
  public void update(DisabilityUpdateRequest disabilityUpdateRequest) {
    validationUtil.validateRequest(disabilityUpdateRequest);
    Disability disability = disabilityRepository.findById(disabilityUpdateRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "disability not found"));
    disabilityMapper.disabilityDtoIntoDisabilityEntity(disability, disabilityUpdateRequest);
    disabilityRepository.save(disability);
  }

  @Override
  public void delete(Short disabilityId) {
    if (disabilityRepository.existsById(disabilityId)) {
      disabilityRepository.deleteById(disabilityId);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "disability not found");
    }
  }
}
