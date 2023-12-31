package alfarezyyd.asclepius.model.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponse {
  @JsonProperty("id")
  private Long personId;
  @JsonProperty("identity_card_number")
  private String identityCardNumber;
  @JsonProperty("identity_card_type")
  private String identityCardType;
  @JsonProperty("full_name")
  private String fullName;
  private String email;
  private String gender;
  private String religion;
  @JsonProperty("blood_type")
  private String bloodType;
  @JsonProperty("birth_place")
  private String birthPlace;
  @JsonProperty("birth_date")
  private String birthDate;
  private Byte age;
  @JsonProperty("marital_status")
  private String maritalStatus;
  @JsonProperty("last_education")
  private String lastEducation;
  @JsonProperty("telephone_number")
  private String telephoneNumber;
}
