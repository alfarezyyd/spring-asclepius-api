package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.speciality.SpecialityCreateRequest;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityResponse;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityUpdateRequest;

import java.util.List;

public interface SpecialityUsecase {
  List<SpecialityResponse> findAll();

  SpecialityResponse findById(String specialityId);

  void create(SpecialityCreateRequest specialityCreateRequest);

  void update(SpecialityUpdateRequest specialityUpdateRequest);

  void delete(String specialityId);
}
