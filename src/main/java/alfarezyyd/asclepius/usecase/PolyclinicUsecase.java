package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicCreateRequest;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicResponse;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicUpdateRequest;

import java.util.List;

public interface PolyclinicUsecase {
  List<PolyclinicResponse> findAll();

  PolyclinicResponse findById(String polyclinicId);

  void create(PolyclinicCreateRequest polyclinicCreateRequest);

  void update(PolyclinicUpdateRequest polyclinicUpdateRequest);

  void delete(String polyclinicId);
}
