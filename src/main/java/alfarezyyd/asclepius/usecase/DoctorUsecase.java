package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.doctor.DoctorCreateRequest;
import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.dto.doctor.DoctorUpdateRequest;

import java.util.List;

public interface DoctorUsecase {
  List<DoctorResponse> findAll();
  DoctorResponse findById(Long personId);
  void create(DoctorCreateRequest doctorCreateRequest);
  void update(DoctorUpdateRequest doctorUpdateRequest);
  void delete(Long personId);
}
