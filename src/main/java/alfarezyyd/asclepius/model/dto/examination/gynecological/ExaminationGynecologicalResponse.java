package alfarezyyd.asclepius.model.dto.examination.gynecological;

import alfarezyyd.asclepius.model.option.FluorAlbus;
import alfarezyyd.asclepius.model.option.Fluxus;
import alfarezyyd.asclepius.model.option.Mobility;
import alfarezyyd.asclepius.model.option.Tenderness;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationGynecologicalResponse {
  @JsonProperty("examination_id")
  private Long examinationId;
  private String inspection;
  private String vulva;
  private String inspeculo;
  private Fluxus fluxus;
  @JsonProperty("fluor_albus")
  private FluorAlbus fluorAlbus;
  @JsonProperty("portio_inspeculo")
  private String portioInspeculo;
  @JsonProperty("sondage_inspeculo")
  private String sondageInspeculo;
  @JsonProperty("internal_portio_inspeculo")
  private String internalPortioInspeculo;
  private String shape;
  @JsonProperty("uterine_cavity")
  private String uterineCavity;
  private Mobility mobility;
  private String size;
  private Tenderness tenderness;
  @JsonProperty("right_adnexa")
  private String rightAdnexa;
  @JsonProperty("left_adnexa")
  private String leftAdnexa;
  @JsonProperty("douglas_cavity")
  private String douglasCavity;
}
