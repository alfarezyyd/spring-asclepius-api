package alfarezyyd.asclepius.model.dto.person;

import alfarezyyd.asclepius.model.dto.address.AddressDto;
import alfarezyyd.asclepius.model.option.*;

import java.sql.Date;

public interface PersonDto {

  String getIdentityCardNumber();

  IdentityCardType getIdentityCardType();

  String getFullName();

  String getEmail();

  Gender getGender();

  Religion getReligion();

  BloodType getBloodType();

  String getBirthPlace();

  Date getBirthDate();

  Byte getAge();

  MaritalStatus getMaritalStatus();

  LastEducation getLastEducation();

  String getTelephoneNumber();

  AddressDto getAddress();
}
