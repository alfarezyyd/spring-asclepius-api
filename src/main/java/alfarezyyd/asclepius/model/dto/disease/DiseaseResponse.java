package alfarezyyd.asclepius.model.dto.disease;

import alfarezyyd.asclepius.model.entity.DiseaseCategory;
import alfarezyyd.asclepius.model.option.ContagiousStatus;
import alfarezyyd.asclepius.model.option.RiskPrognosis;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiseaseResponse {
  private String code;
  private String name;
  private String description;
  private String complication;
  private String indication;
  @JsonProperty("risk_prognosis")
  private RiskPrognosis riskPrognosis;
  @JsonProperty("contagious_status")
  private ContagiousStatus contagiousStatus;
  private String symptom;
  private DiseaseCategory category;
}
