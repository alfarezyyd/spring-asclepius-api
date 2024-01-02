package alfarezyyd.asclepius.model.dto.instance;

import alfarezyyd.asclepius.model.dto.address.AddressResponse;
import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InstanceResponse {
  private String code;
  private String name;
  @JsonProperty("telephone_number")
  private String telephoneNumber;
  private AddressResponse address;
  private List<PatientResponse> patients;
}
