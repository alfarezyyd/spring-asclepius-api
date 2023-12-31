package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import alfarezyyd.asclepius.model.dto.address.AddressDto;
import alfarezyyd.asclepius.model.dto.address.AddressResponse;
import alfarezyyd.asclepius.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AddressMapper {
  AddressResponse addressEntityIntoAddressResponse(Address addressEntity);
  Address addressDtoIntoAddressEntity(@MappingTarget Address addressEntity, AddressDto addressDto);
}
