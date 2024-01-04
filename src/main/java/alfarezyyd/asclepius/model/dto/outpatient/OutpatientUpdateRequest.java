package alfarezyyd.asclepius.model.dto.outpatient;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutpatientUpdateRequest implements OutpatientDto {
  @JsonProperty("registration_code")
  @NotBlank
  @Size(min = 1, max = 18)
  private String registrationCode;
  @NotNull
  private Long doctor;
  @NotNull
  @Size(min = 1, max = 16)
  private String polyclinic;
  @NotNull
  @Size(min = 1, max = 16)
  private String insurance;
  @NotNull
  private Long patient;

}
