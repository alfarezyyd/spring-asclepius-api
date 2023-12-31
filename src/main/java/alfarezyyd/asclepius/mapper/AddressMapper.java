package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.address.AddressDto;
import alfarezyyd.asclepius.model.dto.address.AddressResponse;
import alfarezyyd.asclepius.model.entity.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {
  AddressResponse addressEntityIntoAddressResponse(Address addressEntity);
  Address addressDtoIntoAddressEntity(AddressDto addressDto);
}
