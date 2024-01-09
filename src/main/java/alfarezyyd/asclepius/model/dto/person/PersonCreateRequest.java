package alfarezyyd.asclepius.model.dto.person;

import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import alfarezyyd.asclepius.model.option.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PersonCreateRequest implements PersonDto{
  @JsonProperty("identity_card_number")
  @NotBlank
  @Size(min = 1, max = 20)
  private String identityCardNumber;
  @JsonProperty("identity_card_type")
  @NotBlank
  @Size(min = 1, max = 20)
  private IdentityCardType identityCardType;
  @JsonProperty("full_name")
  @NotBlank
  @Size(min = 1, max = 50)
  private String fullName;
  @NotBlank
  @Size(min = 1, max = 100)
  private String email;
  @NotBlank
  private Gender gender;
  @NotBlank
  private Religion religion;
  @JsonProperty("blood_type")
  @NotBlank
  private BloodType bloodType;
  @JsonProperty("birth_place")
  @NotBlank
  @Size(min = 1, max = 50)
  private String birthPlace;
  @JsonProperty("birth_date")
  @NotBlank
  private Date birthDate;
  @NotNull
  @Min(1)
  @Max(254)
  private Byte age;
  @JsonProperty("marital_status")
  @NotBlank
  private MaritalStatus maritalStatus;
  @JsonProperty("last_education")
  @NotBlank
  private LastEducation lastEducation;
  @JsonProperty("telephone_number")
  @NotBlank
  @Size(min = 11, max = 15)
  private String telephoneNumber;
  @Valid
  @NotNull
  private AddressCreateRequest address;
}
