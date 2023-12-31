package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import alfarezyyd.asclepius.model.dto.address.AddressResponse;
import alfarezyyd.asclepius.model.dto.address.AddressUpdateRequest;
import alfarezyyd.asclepius.model.entity.Person;

import java.util.List;

public interface AddressUsecase {
  List<AddressResponse> findAll();

  AddressResponse findById(Long addressId);

  void create(Person personEntity, AddressCreateRequest addressCreateRequest);

  void update(AddressUpdateRequest addressUpdateRequest);

  void delete(Long addressId);
}
