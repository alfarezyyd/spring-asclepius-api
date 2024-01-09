package alfarezyyd.asclepius.model.dto.examination;

import alfarezyyd.asclepius.model.option.Consciousness;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationResponse {
  private Long id;
  private String subject;
  private String object;
  private Byte temperature;
  @JsonProperty("tension_diastolic")
  private Byte tensionDiastolic;
  @JsonProperty("tension_systolic")
  private Byte tensionSystolic;
  private Short weight;
  private Short height;
  @JsonProperty("respiration_rate")
  private Short respirationRate;
  private Short pulse;
  @JsonProperty("oxygen_saturation")
  private Short oxygenSaturation;
  @JsonProperty("glasgow_coma_scale")
  private Byte glasgowComaScale;
  private Consciousness consciousness;
  private String allergy;
  private String assessment;
  private String plan;
  private String instruction;
  private String evaluation;
  private String note;
}
