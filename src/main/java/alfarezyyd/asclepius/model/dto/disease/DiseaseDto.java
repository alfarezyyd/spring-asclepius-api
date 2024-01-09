package alfarezyyd.asclepius.model.dto.disease;

import alfarezyyd.asclepius.model.option.ContagiousStatus;
import alfarezyyd.asclepius.model.option.RiskPrognosis;

public interface DiseaseDto {
  String getCode();

  String getName();

  String getDescription();

  Integer getCategory();

  String getComplication();

  String getIndication();

  RiskPrognosis getRiskPrognosis();

  ContagiousStatus getContagiousStatus();

  String getSymptom();
}
