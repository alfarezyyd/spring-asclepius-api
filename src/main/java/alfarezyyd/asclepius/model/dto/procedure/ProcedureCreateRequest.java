package alfarezyyd.asclepius.model.dto.procedure;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcedureCreateRequest implements ProcedureDto{
  @NotBlank
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
  @NotBlank
  private String description;
  @JsonProperty("patient_preparation")
  @NotBlank
  private String patientPreparation;
  @JsonProperty("procedure_action")
  @NotBlank
  private String procedureAction;
  @JsonProperty("patient_recovery")
  @NotBlank
  private String patientRecovery;
  @NotNull
  private Integer duration;
}
