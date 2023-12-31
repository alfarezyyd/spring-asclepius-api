package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.speciality.SpecialityCreateRequest;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityUpdateRequest;

import java.util.List;

public interface SpecialityUsecase {
  List<SpecialityUsecase> findAll();

  SpecialityUsecase findById(Long specialityId);

  void create(SpecialityCreateRequest specialityCreateRequest);

  void update(SpecialityUpdateRequest specialityUpdateRequest);

  void delete(Long specialityId);
}
