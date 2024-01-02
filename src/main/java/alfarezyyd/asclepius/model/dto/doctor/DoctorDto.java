package alfarezyyd.asclepius.model.dto.doctor;

import alfarezyyd.asclepius.model.dto.person.PersonDto;

public interface DoctorDto extends PersonDto{
  String getCode();

  String getAlumnus();

  String getPracticePermitNumber();
}
