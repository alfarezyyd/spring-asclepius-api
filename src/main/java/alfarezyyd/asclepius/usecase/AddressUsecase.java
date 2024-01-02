package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import alfarezyyd.asclepius.model.dto.address.AddressResponse;
import alfarezyyd.asclepius.model.dto.address.AddressUpdateRequest;
import alfarezyyd.asclepius.model.entity.Address;

public interface AddressUsecase {
  AddressResponse findById(Long addressId);

  Address create(AddressCreateRequest addressCreateRequest);

  void update(AddressUpdateRequest addressUpdateRequest);

  void delete(Long addressId);
}
