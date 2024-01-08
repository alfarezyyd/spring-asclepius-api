package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.position.PositionCreateRequest;
import alfarezyyd.asclepius.model.dto.position.PositionResponse;
import alfarezyyd.asclepius.model.dto.position.PositionUpdateRequest;
import alfarezyyd.asclepius.model.entity.Position;

import java.util.List;

public interface PositionUsecase {
  List<PositionResponse> findAll();

  PositionResponse findById(String positionCode);

  void create(PositionCreateRequest positionCreateRequest);

  void update(PositionUpdateRequest positionUpdateRequest);

  void delete(String positionCode);
}
