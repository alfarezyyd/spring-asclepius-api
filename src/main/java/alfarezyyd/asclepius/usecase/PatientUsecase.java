package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.patient.PatientCreateRequest;
import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import alfarezyyd.asclepius.model.dto.patient.PatientUpdateRequest;

import java.util.List;

public interface PatientUsecase {
  List<PatientResponse> findAll();
  PatientResponse findById(Long personId);
  void create(PatientCreateRequest patientCreateRequest);
  void update(PatientUpdateRequest patientUpdateRequest);
  void delete(Long personId);
}
