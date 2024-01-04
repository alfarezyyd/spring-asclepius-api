package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.outpatient.OutpatientCreateRequest;
import alfarezyyd.asclepius.model.dto.outpatient.OutpatientResponse;

import java.util.List;

public interface OutpatientUsecase {
  List<OutpatientResponse> findAll();

  OutpatientResponse findById(String registrationCode);

  void create(OutpatientCreateRequest outpatientCreateRequest);

  void delete(String registrationCode);
}
