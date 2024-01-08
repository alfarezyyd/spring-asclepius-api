package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.action.ActionCreateRequest;
import alfarezyyd.asclepius.model.dto.action.ActionResponse;
import alfarezyyd.asclepius.model.dto.action.ActionUpdateRequest;

import java.util.List;

public interface ActionUsecase {
  List<ActionResponse> findAll();

  ActionResponse findById(String actionCode);

  void create(ActionCreateRequest actionCreateRequest);

  void update(ActionUpdateRequest actionUpdateRequest);

  void delete(String actionCode);
}
