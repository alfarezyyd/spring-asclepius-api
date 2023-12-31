package alfarezyyd.asclepius.model.dto.doctor;

import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicResponse;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorResponse {
  private PersonResponse person;
  private String code;
  private String alumnus;
  @JsonProperty("practice_permit_number")
  private String practicePermitNumber;
  @JsonProperty("speciality_code")
  private List<SpecialityResponse> specialityCode;
  @JsonProperty("polyclinic_code")
  private List<PolyclinicResponse> polyclinicCode;
}
