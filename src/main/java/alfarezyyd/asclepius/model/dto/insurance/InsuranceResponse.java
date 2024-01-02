package alfarezyyd.asclepius.model.dto.insurance;

import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InsuranceResponse {
  private String code;
  private String name;
  private String company;
  @JsonProperty("telephone_number")
  private String telephoneNumber;
  private String representative;
  private List<PatientResponse> patients;

}
