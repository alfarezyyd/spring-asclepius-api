package alfarezyyd.asclepius.model.dto.language;

import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LanguageResponse {
  private Short id;
  private String name;
  private List<PatientResponse> patients;
}
