package alfarezyyd.asclepius.model.dto.doctor;

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
public class DoctorCreateRequest extends PersonCreateRequest implements DoctorDto {
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
  @NotNull
  private List<@NotBlank String> specialities;
  @NotNull
  private List<@NotBlank String> polyclinics;
}
