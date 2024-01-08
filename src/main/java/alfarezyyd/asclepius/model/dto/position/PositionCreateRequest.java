package alfarezyyd.asclepius.model.dto.position;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionCreateRequest implements PositionDto {
  @NotBlank
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
}
