package alfarezyyd.asclepius.model.dto.ethnicity;

import alfarezyyd.asclepius.constraint.EthnicityEnumConstraint;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EthnicityUpdateRequest {
  @NotNull
  @Min(1)
  @Max(254)
  private Byte id;
  @NotBlank
  @EthnicityEnumConstraint
  private String type;
  @NotBlank
  @Size(min = 1, max = 50)
  private String name;
}
