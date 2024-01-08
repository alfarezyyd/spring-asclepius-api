package alfarezyyd.asclepius.model.dto.employee;

import alfarezyyd.asclepius.model.dto.person.PersonUpdateRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeUpdateRequest extends PersonUpdateRequest implements EmployeeDto {
  @JsonProperty("position_code")
  @NotBlank
  @Size(min = 1, max = 16)
  private String positionCode;
}
