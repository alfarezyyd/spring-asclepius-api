package alfarezyyd.asclepius.model.dto.ethnicity;

import alfarezyyd.asclepius.model.option.EthnicityType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EthnicityUpdateRequest implements EthnicityDto{
  @NotNull
  private Short id;
  @NotBlank
  private EthnicityType type;
  @NotBlank
  @Size(min = 1, max = 50)
  private String name;
}
