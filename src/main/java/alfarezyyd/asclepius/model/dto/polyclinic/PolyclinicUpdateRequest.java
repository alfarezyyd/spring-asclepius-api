package alfarezyyd.asclepius.model.dto.polyclinic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolyclinicUpdateRequest {
  @NotBlank
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 100)
  private String name;
  @NotBlank
  @Size(min = 1, max = 50)
  private String location;
  private String text;
}