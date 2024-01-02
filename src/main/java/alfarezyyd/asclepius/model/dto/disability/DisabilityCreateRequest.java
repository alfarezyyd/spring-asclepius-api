package alfarezyyd.asclepius.model.dto.disability;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisabilityCreateRequest implements DisabilityDto {
  @NotBlank
  @Size(min = 1, max = 50)
  private String name;
}
