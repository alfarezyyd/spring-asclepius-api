package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.SpecialityMapper;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityCreateRequest;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityResponse;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityUpdateRequest;
import alfarezyyd.asclepius.model.entity.Speciality;
import alfarezyyd.asclepius.repository.SpecialityRepository;
import alfarezyyd.asclepius.usecase.SpecialityUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SpecialityUsecaseImpl implements SpecialityUsecase {
  private final SpecialityRepository specialityRepository;
  private final ValidationUtil validationUtil;
  private final SpecialityMapper specialityMapper;

  public SpecialityUsecaseImpl(SpecialityRepository specialityRepository, ValidationUtil validationUtil, SpecialityMapper specialityMapper) {
    this.specialityRepository = specialityRepository;
    this.validationUtil = validationUtil;
    this.specialityMapper = specialityMapper;
  }

  @Override
  public List<SpecialityResponse> findAll() {
    return specialityRepository.findAll().stream().map(specialityMapper::specialityEntityIntoSpecialityResponseWithoutDoctors).toList();
  }

  @Override
  public SpecialityResponse findById(String specialityId) {
    Speciality speciality = specialityRepository.findById(specialityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "speciality not found"));
    return specialityMapper.specialityEntityIntoSpecialityResponse(speciality);
  }

  @Override
  public void create(SpecialityCreateRequest specialityCreateRequest) {
    validationUtil.validateRequest(specialityCreateRequest);
    Speciality speciality = new Speciality();
    specialityMapper.specialityDtoIntoSpecialityEntity(speciality, specialityCreateRequest);
    specialityRepository.save(speciality);
  }

  @Override
  public void update(SpecialityUpdateRequest specialityUpdateRequest) {
    validationUtil.validateRequest(specialityUpdateRequest);
    Speciality searchedSpeciality = specialityRepository.findById(specialityUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "speciality not found"));
    specialityMapper.specialityDtoIntoSpecialityEntity(searchedSpeciality, specialityUpdateRequest);
    specialityRepository.save(searchedSpeciality);
  }

  @Override
  public void delete(String specialityId) {
    if (specialityRepository.existsById(specialityId)) {
      specialityRepository.deleteById(specialityId);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "speciality not found");
    }
  }
}
