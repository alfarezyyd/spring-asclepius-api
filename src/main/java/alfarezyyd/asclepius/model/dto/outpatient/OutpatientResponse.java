package alfarezyyd.asclepius.model.dto.outpatient;

import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceResponse;
import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutpatientResponse {
  @JsonProperty("registration_code")
  private String registrationCode;
  @JsonProperty("registration_date")
  private String registrationDate;
  private DoctorResponse doctor;
  private PolyclinicResponse polyclinic;
  private InsuranceResponse insurance;
  private PatientResponse patient;
}
