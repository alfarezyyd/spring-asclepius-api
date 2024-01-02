package alfarezyyd.asclepius.model.dto.disability;

import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DisabilityResponse {
  private Short id;
  private String name;
  private List<PatientResponse> patients;

}
