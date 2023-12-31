package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import alfarezyyd.asclepius.model.dto.address.AddressResponse;
import alfarezyyd.asclepius.model.dto.address.AddressUpdateRequest;

import java.util.List;

public interface AddressUsecase {
  List<AddressResponse> findAll();

  AddressResponse findById(Long addressId);

  void create(AddressCreateRequest addressCreateRequest);

  void update(AddressUpdateRequest addressUpdateRequest);

  void delete(Long addressId);
}
