package alfarezyyd.asclepius.model.dto.action;

import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionResponse {
  private String code;
  private String name;
  private Integer fee;
  private ActionCategoryResponse category;
}
