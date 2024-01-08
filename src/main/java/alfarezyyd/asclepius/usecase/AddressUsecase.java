package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import alfarezyyd.asclepius.model.dto.address.AddressUpdateRequest;
import alfarezyyd.asclepius.model.entity.Address;

public interface AddressUsecase {
  Address create(AddressCreateRequest addressCreateRequest);

  void update(AddressUpdateRequest addressUpdateRequest, Address updateAddress);

  void delete(Long addressId);
}
