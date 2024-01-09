package alfarezyyd.asclepius.model.dto.examination;

import alfarezyyd.asclepius.model.option.Consciousness;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationUpdateRequest implements ExaminationDto {
  @JsonIgnore
  @NotNull
  private Long id;
  @NotBlank
  @Size(min = 1, max = 255)
  private String subject;
  @NotBlank
  @Size(min = 1, max = 255)
  private String object;
  @NotNull
  private Byte temperature;
  @JsonProperty("tension_diastolic")
  @NotNull
  private Byte tensionDiastolic;
  @JsonProperty("tension_systolic")
  @NotNull
  private Byte tensionSystolic;
  @NotNull
  private Short weight;
  @NotNull
  private Short height;
  @JsonProperty("respiration_rate")
  @NotNull
  private Short respirationRate;
  @NotNull
  private Short pulse;
  @JsonProperty("oxygen_saturation")
  @NotNull
  private Short oxygenSaturation;
  @JsonProperty("glasgow_coma_scale")
  @NotNull
  private Byte glasgowComaScale;
  @NotNull
  private Consciousness consciousness;
  private String allergy;
  private String assessment;
  private String plan;
  private String instruction;
  private String evaluation;
  private String note;
}
