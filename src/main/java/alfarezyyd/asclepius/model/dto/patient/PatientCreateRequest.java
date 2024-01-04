package alfarezyyd.asclepius.model.dto.patient;

import alfarezyyd.asclepius.constraint.ValidDateConstraint;
import alfarezyyd.asclepius.model.dto.person.PersonCreateRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientCreateRequest extends PersonCreateRequest implements PatientDto {
  @JsonProperty("medical_record_code")
  @NotBlank
  @Size(min = 1, max = 128)
  private String medicalRecordCode;
  @JsonProperty("mother_name")
  @NotBlank
  @Size(min = 1, max = 50)
  private String motherName;
  @JsonProperty("registration_date")
  @NotBlank
  @ValidDateConstraint
  private String registrationDate;
  @NotBlank
  @Size(min = 1, max = 50)
  private String job;
  @JsonProperty("employee_code")
  @NotBlank
  @Size(min = 1, max = 50)
  private String employeeCode;
  @NotNull
  private Short ethnicity;
  private List<Short> disabilities;
  private List<String> insurances;
  private List<@NotNull Short> languages;
  private Long custodian;
  @NotBlank
  @Size(min = 1, max = 16)
  private String instance;
}