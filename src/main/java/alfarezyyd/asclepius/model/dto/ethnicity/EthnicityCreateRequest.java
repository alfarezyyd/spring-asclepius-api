package alfarezyyd.asclepius.model.dto.ethnicity;

import alfarezyyd.asclepius.model.option.EthnicityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EthnicityCreateRequest implements EthnicityDto {
  @NotBlank
  private EthnicityType type;
  @NotBlank
  @Size(min = 1, max = 50)
  private String name;
}
