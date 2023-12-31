package alfarezyyd.asclepius.model.dto.doctor;

import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
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
  private List<@NotNull String> specialityCode;
  @JsonProperty("polyclinic_code")
  private List<@NotNull String> polyclinicCode;
}
