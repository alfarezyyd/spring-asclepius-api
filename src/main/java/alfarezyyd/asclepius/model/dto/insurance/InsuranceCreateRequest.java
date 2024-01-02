package alfarezyyd.asclepius.model.dto.insurance;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceCreateRequest implements InsuranceDto{
  @NotBlank
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 100)
  private String name;
  @NotBlank
  @Size(min = 1, max = 100)
  private String company;
  @NotBlank
  @Size(min = 1, max = 15)
  @JsonProperty("telephone_number")
  private String telephoneNumber;
  @NotBlank
  @Size(min = 1, max = 50)
  private String representative;

}
