package alfarezyyd.asclepius.model.dto.disease;

import alfarezyyd.asclepius.model.option.ContagiousStatus;
import alfarezyyd.asclepius.model.option.RiskPrognosis;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiseaseCreateRequest {
  @NotBlank
  @Size(min = 1, max = 10)
  private String code;
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
  @NotBlank
  private String description;
  @NotNull
  private Integer category;
  @NotBlank
  private String complication;
  @NotBlank
  private String indication;
  @JsonProperty("risk_prognosis")
  @NotNull
  private RiskPrognosis riskPrognosis;
  @JsonProperty("contagious_status")
  @NotNull
  private ContagiousStatus contagiousStatus;
  @NotBlank
  private String symptom;
}
