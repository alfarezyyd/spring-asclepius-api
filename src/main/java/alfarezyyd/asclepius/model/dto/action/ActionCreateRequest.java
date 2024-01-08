package alfarezyyd.asclepius.model.dto.action;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ActionCreateRequest implements ActionDto {
  @NotBlank
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
