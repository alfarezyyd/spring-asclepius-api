package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.helper.Model;
import alfarezyyd.asclepius.mapper.AddressMapper;
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
  private final AddressMapper addressMapper;

  public AddressUsecaseImpl(AddressRepository addressRepository, ValidationUtil validationUtil, AddressMapper addressMapper) {
    this.addressRepository = addressRepository;
    this.validationUtil = validationUtil;
    this.addressMapper = addressMapper;
  }

  @Override
  public List<AddressResponse> findAll() {
    List<Address> allAddress = addressRepository.findAll();
    return allAddress.stream().map(addressMapper::addressEntityIntoAddressResponse).toList();
  }

  @Override
  public AddressResponse findById(Long addressId) {
    Address addressEntity = addressRepository.findById(addressId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    return addressMapper.addressEntityIntoAddressResponse(addressEntity);
  }

  @Override
  public void create(AddressCreateRequest addressCreateRequest) {
    validationUtil.validateRequest(addressCreateRequest);
    Address newAddress = new Address();
    addressMapper.addressDtoIntoAddressEntity(newAddress, addressCreateRequest);
    addressRepository.save(newAddress);
  }

  @Override
  public void update(AddressUpdateRequest addressUpdateRequest) {
    validationUtil.validateRequest(addressUpdateRequest);
    Address searchedAddress = addressRepository.findById(addressUpdateRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "address not found"));
    addressMapper.addressDtoIntoAddressEntity(searchedAddress, addressUpdateRequest);
    addressRepository.save(searchedAddress);
  }

  @Override
  public void delete(Long addressId) {
    if (addressRepository.existsById(addressId)) {
      addressRepository.deleteById(addressId);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "address not found");
    }
  }
}
