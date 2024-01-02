package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.disability.DisabilityCreateRequest;
import alfarezyyd.asclepius.model.dto.disability.DisabilityResponse;
import alfarezyyd.asclepius.model.dto.disability.DisabilityUpdateRequest;

import java.util.List;

public interface DisabilityUsecase {
  List<DisabilityResponse> findAll();

  DisabilityResponse findById(Short disabilityId);

  void create(DisabilityCreateRequest disabilityCreateRequest);

  void update(DisabilityUpdateRequest disabilityUpdateRequest);

  void delete(Short disabilityId);
}
