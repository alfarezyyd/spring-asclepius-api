package alfarezyyd.asclepius.model.dto.procedure;

public interface ProcedureDto {

  String getCode();


  String getName();


  String getDescription();


  String getPatientPreparation();


  String getProcedureAction();


  String getPatientRecovery();


  Integer getDuration();
}