package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.helper.Model;
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

  public SpecialityUsecaseImpl(SpecialityRepository specialityRepository, ValidationUtil validationUtil) {
    this.specialityRepository = specialityRepository;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<SpecialityResponse> findAll() {
    return specialityRepository.findAll().stream().map(speciality -> Model.convertIntoSpecialityResponse(null, speciality)).toList();
  }

  @Override
  public SpecialityResponse findById(String specialityId) {
    Speciality speciality = specialityRepository.findById(specialityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "speciality not found"));
    return Model.convertIntoSpecialityResponse(null, speciality);
  }

  @Override
  public void create(SpecialityCreateRequest specialityCreateRequest) {
    validationUtil.validateRequest(specialityCreateRequest);
    Speciality speciality = new Speciality();
    speciality.setCode(specialityCreateRequest.getCode());
    speciality.setName(specialityCreateRequest.getName());
    speciality.setText(specialityCreateRequest.getText());
    specialityRepository.save(speciality);
  }

  @Override
  public void update(SpecialityUpdateRequest specialityUpdateRequest) {
    validationUtil.validateRequest(specialityUpdateRequest);
    Speciality searchedSpeciality = specialityRepository.findById(specialityUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "speciality not found"));
    searchedSpeciality.setName(specialityUpdateRequest.getName());
    searchedSpeciality.setText(specialityUpdateRequest.getText());
    specialityRepository.save(searchedSpeciality);
  }

  @Override
  public void delete(String specialityId) {
    if (specialityRepository.existsById(specialityId)) {
      specialityRepository.deleteById(specialityId);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "speciality not found");
    }
  }
}
