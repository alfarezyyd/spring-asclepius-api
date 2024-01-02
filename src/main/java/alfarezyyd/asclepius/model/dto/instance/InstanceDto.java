package alfarezyyd.asclepius.model.dto.instance;

import alfarezyyd.asclepius.model.dto.address.AddressDto;

public interface InstanceDto {
  String getCode();

  String getName();

  String getTelephoneNumber();

  AddressDto getAddress();

}
