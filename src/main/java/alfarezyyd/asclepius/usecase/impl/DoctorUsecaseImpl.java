package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.model.dto.doctor.DoctorCreateRequest;
import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.dto.doctor.DoctorUpdateRequest;
import alfarezyyd.asclepius.usecase.DoctorUsecase;

import java.util.List;

public class DoctorUsecaseImpl implements DoctorUsecase {
  @Override
  public List<DoctorResponse> findAll() {
    return null;
  }

  @Override
  public DoctorResponse findById(Long doctorId) {
    return null;
  }

  @Override
  public void create(DoctorCreateRequest doctorCreateRequest) {

  }

  @Override
  public void update(DoctorUpdateRequest doctorUpdateRequest) {

  }

  @Override
  public void delete(Long doctorId) {

  }
}
