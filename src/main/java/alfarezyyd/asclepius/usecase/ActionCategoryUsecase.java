package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryCreateRequest;
import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryResponse;
import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryUpdateRequest;

import java.util.List;

public interface ActionCategoryUsecase {
  List<ActionCategoryResponse> findAll();

  ActionCategoryResponse findById(Integer actionCategoryId);

  void create(ActionCategoryCreateRequest actionCategoryCreateRequest);

  void update(ActionCategoryUpdateRequest actionCategoryUpdateRequest);

  void delete(Integer actionCategoryId);
}
