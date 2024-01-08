package alfarezyyd.asclepius.model.dto.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionUpdateRequest implements ActionDto{
  @NotBlank
  @JsonIgnore
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
  @NotNull
  private Integer fee;
  @NotNull
  private Integer category;
}
