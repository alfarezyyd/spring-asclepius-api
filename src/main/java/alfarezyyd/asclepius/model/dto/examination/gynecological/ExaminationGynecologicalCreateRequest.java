package alfarezyyd.asclepius.model.dto.examination.gynecological;

import alfarezyyd.asclepius.model.option.FluorAlbus;
import alfarezyyd.asclepius.model.option.Fluxus;
import alfarezyyd.asclepius.model.option.Mobility;
import alfarezyyd.asclepius.model.option.Tenderness;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationGynecologicalCreateRequest implements ExaminationGynecologicalDto{
  @JsonProperty("examination_id")
  @NotNull
  private Long examinationId;
  @NotBlank
  @Size(min = 1, max = 255)
  private String inspection;
  @NotBlank
  @Size(min = 1, max = 255)
  private String vulva;
  @NotBlank
  @Size(min = 1, max = 255)
  private String inspeculo;
  @NotNull
  private Fluxus fluxus;
  @JsonProperty("fluor_albus")
  @NotNull
  private FluorAlbus fluorAlbus;
  @NotBlank
  @Size(min = 1, max = 255)
  @JsonProperty("portio_inspeculo")
  private String portioInspeculo;
  @NotBlank
  @Size(min = 1, max = 255)
  @JsonProperty("sondage_inspeculo")
  private String sondageInspeculo;
  @NotBlank
  @Size(min = 1, max = 255)
  @JsonProperty("internal_portio_inspeculo")
  private String internalPortioInspeculo;
  @NotBlank
  @Size(min = 1, max = 255)
  private String shape;
  @JsonProperty("uterine_cavity")
  @NotBlank
  @Size(min = 1, max = 255)
  private String uterineCavity;
  @NotNull
  private Mobility mobility;
  @NotBlank
  @Size(min = 1, max = 255)
  private String size;
  @NotNull
  private Tenderness tenderness;
  @NotBlank
  @Size(min = 1, max = 255)
  @JsonProperty("right_adnexa")
  private String rightAdnexa;
  @NotBlank
  @Size(min = 1, max = 255)
  @JsonProperty("left_adnexa")
  private String leftAdnexa;
  @NotBlank
  @Size(min = 1, max = 255)
  @JsonProperty("douglas_cavity")
  private String douglasCavity;
}
