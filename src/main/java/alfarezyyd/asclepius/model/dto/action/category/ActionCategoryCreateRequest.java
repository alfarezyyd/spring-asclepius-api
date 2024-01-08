package alfarezyyd.asclepius.model.dto.action.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionCategoryCreateRequest implements ActionCategoryDto{
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
}
