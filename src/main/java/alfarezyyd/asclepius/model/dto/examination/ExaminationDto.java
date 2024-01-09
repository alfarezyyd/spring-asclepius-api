package alfarezyyd.asclepius.model.dto.examination;

import alfarezyyd.asclepius.model.option.Consciousness;

public interface ExaminationDto {
  String getSubject();

  String getObject();

  Byte getTemperature();

  Byte getTensionDiastolic();

  Byte getTensionSystolic();

  Short getWeight();

  Short getHeight();

  Short getRespirationRate();

  Short getPulse();

  Short getOxygenSaturation();

  Byte getGlasgowComaScale();

  Consciousness getConsciousness();

  String getAllergy();

  String getAssessment();

  String getPlan();

  String getInstruction();

  String getEvaluation();

  String getNote();
}
