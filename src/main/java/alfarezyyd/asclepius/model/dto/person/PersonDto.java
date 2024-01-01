package alfarezyyd.asclepius.model.dto.person;

import alfarezyyd.asclepius.model.dto.address.AddressDto;

public interface PersonDto {

  String getIdentityCardNumber();

  String getIdentityCardType();

  String getFullName();

  String getEmail();

  String getGender();

  String getReligion();

  String getBloodType();

  String getBirthPlace();

  String getBirthDate();

  Byte getAge();

  String getMaritalStatus();

  String getLastEducation();

  String getTelephoneNumber();

  AddressDto getAddress();
}
