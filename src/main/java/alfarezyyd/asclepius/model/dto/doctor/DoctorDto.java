package alfarezyyd.asclepius.model.dto.doctor;

import alfarezyyd.asclepius.model.dto.person.PersonDto;

import java.util.List;

public interface DoctorDto extends PersonDto {
  String getCode();

  String getAlumnus();

  String getPracticePermitNumber();

  List<String> getSpecialities();

  List<String> getPolyclinics();
}
