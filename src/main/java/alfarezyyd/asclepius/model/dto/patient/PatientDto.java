package alfarezyyd.asclepius.model.dto.patient;

import alfarezyyd.asclepius.model.dto.person.PersonDto;

import java.sql.Date;
import java.util.List;

public interface PatientDto extends PersonDto {

  String getMedicalRecordCode();

  String getMotherName();

  Date getRegistrationDate();

  String getJob();

  String getEmployeeCode();

  Short getEthnicity();

  List<Short> getDisabilities();

  List<String> getInsurances();

  List<Short> getLanguages();

  Long getCustodian();

  String getInstance();
}
