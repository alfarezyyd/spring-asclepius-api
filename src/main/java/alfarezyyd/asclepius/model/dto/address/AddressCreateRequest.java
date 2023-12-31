package alfarezyyd.asclepius.model.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressCreateRequest implements AddressDto{
  @JsonProperty("urban_village_name")
  @NotBlank
  @Size(min = 1, max = 100)
  private String urbanVillageName;
  @JsonProperty("sub_district_name")
  @NotBlank
  @Size(min = 1, max = 100)
  private String subDistrictName;
  @JsonProperty("district_name")
  @NotBlank
  @Size(min = 1, max = 100)
  private String districtName;
  @JsonProperty("province_name")
  @NotBlank
  @Size(min = 1, max = 100)
  private String provinceName;
  @JsonProperty("neighbourhood_number")
  @NotBlank
  @Size(min = 1, max = 5)
  private String neighbourhoodNumber;
  @JsonProperty("hamlet_number")
  @NotBlank
  @Size(min = 1, max = 5)
  private String hamletNumber;
  @JsonProperty("postal_code")
  @NotBlank
  @Size(min = 1, max = 5)
  private String postalCode;
}
