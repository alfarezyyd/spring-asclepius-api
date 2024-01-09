package alfarezyyd.asclepius.model.dto.examination.obstetric;

import alfarezyyd.asclepius.model.option.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationObstetricCreateRequest implements ExaminationObstetricDto {
  @JsonProperty("examination_id")
  @NotNull
  private Long examinationId;
  @JsonProperty("uterine_fundus_height")
  @NotNull
  private Byte uterineFundusHeight;
  @NotNull
  private Fetus fetus;
  @NotBlank
  @Size(min = 1, max = 255)
  private String location;
  @NotNull
  private Contraction contraction;
  @NotNull
  private Short quality;
  @NotBlank
  @Size(min = 1, max = 255)
  private String vulva;
  @JsonProperty("portio_inspeculo")

  @NotBlank
  @Size(min = 1, max = 255)
  private String portioInspeculo;
  @JsonProperty("pelvis_lower_part")
  @NotNull
  private Byte pelvisLowerPart;
  @JsonProperty("cervical_opening")
  @NotBlank
  private String cervicalOpening;
  @JsonProperty("cervical_descent")
  @NotBlank
  private String cervicalDescent;
  @NotNull
  private Fluxus fluxus;
  @JsonProperty("fluor_albus")
  @NotNull
  private FluorAlbus fluorAlbus;
  @JsonProperty("amniotic_membrane")
  @NotNull
  private AmnioticMembrane amnioticMembrane;
  @JsonProperty("vulva_condition")
  @NotNull
  private VulvaCondition vulvaCondition;
  @NotBlank
  @Size(min = 1, max = 255)
  private String denominator;
  @NotNull
  private Direction direction;
  @JsonProperty("feto_pelvic_balance")
  @NotNull
  private FetoPelvicBalance fetoPelvicBalance;
}

