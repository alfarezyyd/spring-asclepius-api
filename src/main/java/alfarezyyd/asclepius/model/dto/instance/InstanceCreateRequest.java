package alfarezyyd.asclepius.model.dto.instance;

import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstanceCreateRequest {
  @NotBlank
  @Size(min = 1, max = 16)
  private String code;
  @NotBlank
  @Size(min = 1, max = 100)
  private String name;
  @NotBlank
  @Size(min = 1, max = 15)
  @JsonProperty("telephone_number")
  private String telephoneNumber;
  @Valid
  private AddressCreateRequest address;
}
