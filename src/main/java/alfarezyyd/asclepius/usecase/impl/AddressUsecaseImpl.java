package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.helper.Model;
import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import alfarezyyd.asclepius.model.dto.address.AddressResponse;
import alfarezyyd.asclepius.model.dto.address.AddressUpdateRequest;
import alfarezyyd.asclepius.model.entity.Address;
import alfarezyyd.asclepius.repository.AddressRepository;
import alfarezyyd.asclepius.usecase.AddressUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AddressUsecaseImpl implements AddressUsecase {
  private final AddressRepository addressRepository;
  private final ValidationUtil validationUtil;

  public AddressUsecaseImpl(AddressRepository addressRepository, ValidationUtil validationUtil) {
    this.addressRepository = addressRepository;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<AddressResponse> findAll() {
    List<Address> allAddress = addressRepository.findAll();
    return allAddress.stream().map(address -> Model.convertIntoAddressResponse(null, address)).toList();
  }

  @Override
  public AddressResponse findById(Long addressId) {
    Address addressEntity = addressRepository.findById(addressId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    return Model.convertIntoAddressResponse(null, addressEntity);
  }

  @Override
  public void create(AddressCreateRequest addressCreateRequest) {
    validationUtil.validateRequest(addressCreateRequest);
    addressRepository.save(Model.constructAddressEntity(new Address(), addressCreateRequest));
  }

  @Override
  public void update(AddressUpdateRequest addressUpdateRequest) {
    validationUtil.validateRequest(addressUpdateRequest);
    Address searchedAddress = addressRepository.findById(addressUpdateRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "address not found"));
    addressRepository.save(Model.constructAddressEntity(searchedAddress, addressUpdateRequest));
  }

  @Override
  public void delete(Long addressId) {
    if (addressRepository.existsById(addressId)) {
      addressRepository.deleteById(addressId);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "address not found");
    }
  }
}
