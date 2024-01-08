package alfarezyyd.asclepius.model.dto.action.category;

import alfarezyyd.asclepius.model.dto.action.ActionResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActionCategoryResponse {
  private Integer id;
  private String name;
  private List<ActionResponse> actions;
}
