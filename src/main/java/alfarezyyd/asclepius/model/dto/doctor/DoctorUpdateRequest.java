package alfarezyyd.asclepius.model.dto.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorUpdateRequest {
  @NotBlank
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 100)
  private String alumnus;
  @NotBlank
  @Size(min = 1, max = 30)
  @JsonProperty("practice_permit_number")
  private String practicePermitNumber;
  @JsonProperty("speciality_code")
  private List<@NotNull String> specialityCode;
  @JsonProperty("polyclinic_code")
  private List<@NotNull String> polyclinicCode;
}