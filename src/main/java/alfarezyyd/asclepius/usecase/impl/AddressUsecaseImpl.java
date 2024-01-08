package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.AddressMapper;
import alfarezyyd.asclepius.model.dto.address.AddressCreateRequest;
import alfarezyyd.asclepius.model.dto.address.AddressUpdateRequest;
import alfarezyyd.asclepius.model.entity.Address;
import alfarezyyd.asclepius.repository.AddressRepository;
import alfarezyyd.asclepius.usecase.AddressUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
  @Transactional
  public Address create(AddressCreateRequest addressCreateRequest) {
    validationUtil.validateRequest(addressCreateRequest);
    Address newAddress = new Address();
    addressMapper.addressDtoIntoAddressEntity(newAddress, addressCreateRequest);
    addressRepository.save(newAddress);
    return newAddress;
  }

  @Override
  public void update(AddressUpdateRequest addressUpdateRequest, Address updateAddress) {
    Address tempAddress = new Address();
    addressMapper.addressDtoIntoAddressEntity(tempAddress, addressUpdateRequest);
    if (!tempAddress.equals(updateAddress)) {
      addressRepository.save(updateAddress);
    }
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
