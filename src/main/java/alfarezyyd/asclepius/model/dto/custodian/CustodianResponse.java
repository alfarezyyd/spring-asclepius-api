package alfarezyyd.asclepius.model.dto.custodian;

import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import alfarezyyd.asclepius.model.option.Relation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustodianResponse extends PersonResponse {
  private Relation relation;
  private String job;
  private List<PatientResponse> patients;

}
