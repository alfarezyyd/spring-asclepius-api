package alfarezyyd.asclepius.model.dto.disability;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisabilityUpdateRequest implements DisabilityDto {
  @JsonIgnore
  @NotBlank
  private Short id;
  @NotBlank
  @Size(min = 1, max = 50)
  private String name;
}
