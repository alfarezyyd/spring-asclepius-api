package alfarezyyd.asclepius.model.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
  private Long id;
  @JsonProperty("urban_village_name")
  private String urbanVillageName;
  @JsonProperty("sub_district_name")
  private String subDistrictName;
  @JsonProperty("district_name")
  private String districtName;
  @JsonProperty("province_name")
  private String provinceName;
  @JsonProperty("neighbourhood_number")
  private String neighbourhoodNumber;
  @JsonProperty("hamlet_number")
  private String hamletNumber;
  @JsonProperty("postal_code")
  private String postalCode;
}
