package alfarezyyd.asclepius.model.dto.patient;

import alfarezyyd.asclepius.model.dto.custodian.CustodianResponse;
import alfarezyyd.asclepius.model.dto.disability.DisabilityResponse;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityResponse;
import alfarezyyd.asclepius.model.dto.instance.InstanceResponse;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceResponse;
import alfarezyyd.asclepius.model.dto.language.LanguageResponse;
import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class PatientResponse extends PersonResponse {
  @JsonProperty("medical_record_code")
  private String medicalRecordCode;
  @JsonProperty("mother_name")
  private String motherName;
  @JsonProperty("registration_date")
  private Date registrationDate;
  private String job;
  @JsonProperty("employee_code")
  private String employeeCode;
  private EthnicityResponse ethnicity;
  private List<DisabilityResponse> disabilities;
  private List<InsuranceResponse> insurances;
  private List<LanguageResponse> languages;
  private CustodianResponse custodian;
  private InstanceResponse instance;

}
