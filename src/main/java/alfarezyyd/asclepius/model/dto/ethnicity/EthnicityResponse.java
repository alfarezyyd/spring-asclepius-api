package alfarezyyd.asclepius.model.dto.ethnicity;

import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EthnicityResponse {
  private Short id;
  private String type;
  private String name;
  private List<PatientResponse> patients;
}
