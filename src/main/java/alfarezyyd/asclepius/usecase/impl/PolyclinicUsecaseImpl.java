package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.PolyclinicMapper;
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
  private final PolyclinicMapper polyclinicMapper;

  public PolyclinicUsecaseImpl(PolyclinicRepository polyclinicRepository, ValidationUtil validationUtil, PolyclinicMapper polyclinicMapper) {
    this.polyclinicRepository = polyclinicRepository;
    this.validationUtil = validationUtil;
    this.polyclinicMapper = polyclinicMapper;
  }

  @Override
  public List<PolyclinicResponse> findAll() {
    List<Polyclinic> allPolyclinic = polyclinicRepository.findAll();
    return allPolyclinic.stream().map(polyclinicMapper::polyclinicEntityIntoPolyclinicResponse).toList();
  }

  @Override
  public PolyclinicResponse findById(String polyclinicId) {
    Polyclinic polyclinic = polyclinicRepository.findById(polyclinicId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "polyclinic not found"));
    return polyclinicMapper.polyclinicEntityIntoPolyclinicResponse(polyclinic);
  }

  @Override
  public void create(PolyclinicCreateRequest polyclinicCreateRequest) {
    validationUtil.validateRequest(polyclinicCreateRequest);
    Polyclinic polyclinicEntity = new Polyclinic();
    polyclinicMapper.polyclinicDtoIntoPolyclinicEntity(polyclinicEntity, polyclinicCreateRequest);
    polyclinicRepository.save(polyclinicEntity);
  }

  @Override
  public void update(PolyclinicUpdateRequest polyclinicUpdateRequest) {
    validationUtil.validateRequest(polyclinicUpdateRequest);
    Polyclinic searchedPolyclinic = polyclinicRepository.findById(polyclinicUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "polyclinic not found"));
    polyclinicMapper.polyclinicDtoIntoPolyclinicEntity(searchedPolyclinic, polyclinicUpdateRequest);
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
