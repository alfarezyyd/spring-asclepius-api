package alfarezyyd.asclepius.model.dto.outpatient.action;

import alfarezyyd.asclepius.model.option.ActionPerformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutpatientActionUpdateRequest implements OutpatientActionDto {
  @NotBlank
  @Size(min = 1, max = 16)
  @JsonProperty("action_code")
  private String actionCode;
  @NotBlank
  @Size(min = 1, max = 18)
  @JsonProperty("registration_code")
  private String registrationCode;
  @NotNull
  @JsonProperty("action_performer")
  private ActionPerformer actionPerformer;
}
