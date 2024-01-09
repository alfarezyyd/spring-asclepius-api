package alfarezyyd.asclepius.model.dto.examination.obstetric;

import alfarezyyd.asclepius.model.option.*;

public interface ExaminationObstetricDto {

  Long getExaminationId();

  Byte getUterineFundusHeight();

  Fetus getFetus();

  String getLocation();

  Contraction getContraction();

  Short getQuality();

  String getVulva();

  String getPortioInspeculo();

  Byte getPelvisLowerPart();

  String getCervicalOpening();

  String getCervicalDescent();

  Fluxus getFluxus();

  FluorAlbus getFluorAlbus();

  AmnioticMembrane getAmnioticMembrane();

  VulvaCondition getVulvaCondition();

  String getDenominator();

  Direction getDirection();

  FetoPelvicBalance getFetoPelvicBalance();
}
