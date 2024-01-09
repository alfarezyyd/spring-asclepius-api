package alfarezyyd.asclepius.model.dto.examination.obstetric;

import alfarezyyd.asclepius.model.option.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationObstetricResponse {
  @JsonProperty("examination_id")
  private Long examinationId;
  @JsonProperty("uterine_fundus_height")
  private Byte uterineFundusHeight;
  private Fetus fetus;
  private String location;
  private Contraction contraction;
  private Short quality;
  private String vulva;
  @JsonProperty("portio_inspeculo")
  private String portioInspeculo;
  @JsonProperty("pelvis_lower_part")
  private Byte pelvisLowerPart;
  @JsonProperty("cervical_opening")
  private String cervicalOpening;
  @JsonProperty("cervical_descent")
  private String cervicalDescent;
  private Fluxus fluxus;
  @JsonProperty("fluor_albus")
  private FluorAlbus fluorAlbus;
  @JsonProperty("amniotic_membrane")
  private AmnioticMembrane amnioticMembrane;
  @JsonProperty("vulva_condition")
  private VulvaCondition vulvaCondition;
  private String denominator;
  private Direction direction;
  @JsonProperty("feto_pelvic_balance")
  private FetoPelvicBalance fetoPelvicBalance;
}
