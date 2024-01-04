package alfarezyyd.asclepius.model.dto.polyclinic;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolyclinicUpdateRequest implements PolyclinicDto {
  @NotBlank
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 100)
  private String name;
  @JsonProperty("registration_fee")
  @NotNull
  private Integer registrationFee;
  @NotBlank
  @Size(min = 1, max = 50)
  private String location;
  private String note;
}