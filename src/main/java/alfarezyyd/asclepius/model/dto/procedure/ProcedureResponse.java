package alfarezyyd.asclepius.model.dto.procedure;

import alfarezyyd.asclepius.model.dto.disease.DiseaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProcedureResponse {
  private String code;
  private String name;
  private String description;
  @JsonProperty("patient_preparation")
  private String patientPreparation;
  @JsonProperty("procedure_action")
  private String procedureAction;
  @JsonProperty("patient_recovery")
  private String patientRecovery;
  private Integer duration;
  private List<DiseaseResponse> diseases;
}
