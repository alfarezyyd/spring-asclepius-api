package alfarezyyd.asclepius.model.dto.person;

import alfarezyyd.asclepius.constraint.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonUpdateRequest {
  @NotNull
  @JsonIgnore
  private Long personId;
  @JsonProperty("identity_card_number")
  @NotBlank
  @Size(min = 1, max = 20)
  private String identityCardNumber;
  @JsonProperty("identity_card_type")
  @NotBlank
  @Size(min = 1, max = 20)
  @IdentityCardTypeEnumConstraint
  private String identityCardType;
  @JsonProperty("full_name")
  @NotBlank
  @Size(min = 1, max = 50)
  private String fullName;
  @NotBlank
  @Size(min = 1, max = 100)
  private String email;
  @NotBlank
  @GenderEnumConstraint
  private String gender;
  @NotBlank
  @ReligionEnumConstraint
  private String religion;
  @JsonProperty("blood_type")
  @NotBlank
  @BloodTypeEnumConstraint
  private String bloodType;
  @JsonProperty("birth_place")
  @NotBlank
  @Size(min = 1, max = 50)
  private String birthPlace;
  @JsonProperty("birth_date")
  @NotBlank
  @ValidDateConstraint
  private String birthDate;
  @NotBlank
  @Size(min = 1, max = 254)
  private Byte age;
  @JsonProperty("marital_status")
  @NotBlank
  @MaritalStatusEnumConstraint
  private String maritalStatus;
  @JsonProperty("last_education")
  @NotBlank
  @LastEducationEnumConstraint
  private String lastEducation;
  @JsonProperty("telephone_number")
  @NotBlank
  @Size(min = 11, max = 15)
  private String telephoneNumber;
}
