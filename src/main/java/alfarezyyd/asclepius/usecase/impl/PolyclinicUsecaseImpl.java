package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.helper.Model;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicCreateRequest;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicResponse;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicUpdateRequest;
import alfarezyyd.asclepius.model.entity.Polyclinic;
import alfarezyyd.asclepius.repository.PolyclinicRepository;
import alfarezyyd.asclepius.usecase.PolyclinicUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PolyclinicUsecaseImpl implements PolyclinicUsecase {
  private final PolyclinicRepository polyclinicRepository;
  private final ValidationUtil validationUtil;

  public PolyclinicUsecaseImpl(PolyclinicRepository polyclinicRepository, ValidationUtil validationUtil) {
    this.polyclinicRepository = polyclinicRepository;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<PolyclinicResponse> findAll() {
    List<Polyclinic> allPolyclinic = polyclinicRepository.findAll();
    return allPolyclinic.stream().map(polyclinic -> Model.convertIntoPolyclinicResponse(null, polyclinic)).toList();
  }

  @Override
  public PolyclinicResponse findById(String polyclinicId) {
    Polyclinic polyclinic = polyclinicRepository.findById(polyclinicId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "polyclinic not found"));
    return Model.convertIntoPolyclinicResponse(null, polyclinic);
  }

  @Override
  public void create(PolyclinicCreateRequest polyclinicCreateRequest) {
    validationUtil.validateRequest(polyclinicCreateRequest);
    Polyclinic polyclinicEntity = new Polyclinic();
    polyclinicEntity.setCode(polyclinicCreateRequest.getCode());
    polyclinicEntity.setName(polyclinicCreateRequest.getName());
    polyclinicEntity.setLocation(polyclinicCreateRequest.getLocation());
    polyclinicRepository.save(polyclinicEntity);
  }

  @Override
  public void update(PolyclinicUpdateRequest polyclinicUpdateRequest) {
    validationUtil.validateRequest(polyclinicUpdateRequest);
    Polyclinic searchedPolyclinic = polyclinicRepository.findById(polyclinicUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "polyclinic not found"));
    searchedPolyclinic.setCode(polyclinicUpdateRequest.getCode());
    searchedPolyclinic.setName(polyclinicUpdateRequest.getName());
    searchedPolyclinic.setLocation(polyclinicUpdateRequest.getLocation());
    polyclinicRepository.save(searchedPolyclinic);
  }

  @Override
  public void delete(String polyclinicId) {
    if (polyclinicRepository.existsById(polyclinicId)) {
      polyclinicRepository.deleteById(polyclinicId);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "polyclinic not found");
    }
  }
}
