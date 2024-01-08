package alfarezyyd.asclepius.model.dto.position;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionUpdateRequest implements PositionDto {
  @NotBlank
  @JsonIgnore
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
}
