package alfarezyyd.asclepius.model.dto.doctor;

import alfarezyyd.asclepius.model.dto.person.PersonDto;

import java.util.List;

public interface DoctorDto {
  PersonDto getPerson();

  String getCode();

  String getAlumnus();

  String getPracticePermitNumber();

  List<String> getSpecialityCode();

  List<String> getPolyclinicCode();
}
