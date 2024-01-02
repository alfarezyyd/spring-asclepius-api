package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.AddressMapper;
import alfarezyyd.asclepius.mapper.DoctorMapper;
import alfarezyyd.asclepius.model.dto.doctor.DoctorCreateRequest;
import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.dto.doctor.DoctorUpdateRequest;
import alfarezyyd.asclepius.model.entity.Address;
import alfarezyyd.asclepius.model.entity.Doctor;
import alfarezyyd.asclepius.repository.DoctorRepository;
import alfarezyyd.asclepius.usecase.AddressUsecase;
import alfarezyyd.asclepius.usecase.DoctorUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DoctorUsecaseImpl implements DoctorUsecase {
  private final DoctorRepository doctorRepository;
  private final AddressUsecase addressUsecase;
  private final ValidationUtil validationUtil;
  private final DoctorMapper doctorMapper;
  private final AddressMapper addressMapper;

  public DoctorUsecaseImpl(DoctorRepository doctorRepository, AddressUsecase addressUsecase, ValidationUtil validationUtil, DoctorMapper doctorMapper, AddressMapper addressMapper) {
    this.doctorRepository = doctorRepository;
    this.addressUsecase = addressUsecase;
    this.validationUtil = validationUtil;
    this.doctorMapper = doctorMapper;
    this.addressMapper = addressMapper;
  }

  @Override
  public List<DoctorResponse> findAll() {
    return doctorRepository.findAll().stream().map(doctorMapper::doctorEntityIntoDoctorResponse).toList();
  }

  @Override
  public DoctorResponse findById(Long personId) {
    Doctor searchedDoctor = doctorRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found"));
    return doctorMapper.doctorEntityIntoDoctorResponse(searchedDoctor);
  }

  @Override
  @Transactional
  public void create(DoctorCreateRequest doctorCreateRequest) {
    validationUtil.validateRequest(doctorCreateRequest);
    Address address = addressUsecase.create(doctorCreateRequest.getAddress());
    Doctor doctor = new Doctor();
    doctor.setAddress(address);
    doctorMapper.doctorDtoIntoDoctorEntity(doctor, doctorCreateRequest);
    doctorRepository.save(doctor);
  }

  @Override
  public void update(DoctorUpdateRequest doctorUpdateRequest) {
    validationUtil.validateRequest(doctorUpdateRequest);
    Doctor searchedDoctor = doctorRepository.findById(doctorUpdateRequest.getPersonId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found"));
    Address updateAddress = new Address();
    addressMapper.addressDtoIntoAddressEntity(updateAddress, doctorUpdateRequest.getAddress());
    if (!updateAddress.equals(searchedDoctor.getAddress())) {
      addressUsecase.update(searchedDoctor.getAddress().getId(), doctorUpdateRequest.getAddress());
    }
    doctorMapper.doctorDtoIntoDoctorEntity(searchedDoctor, doctorUpdateRequest);
    doctorRepository.save(searchedDoctor);

  }

  @Override
  public void delete(Long personId) {
    Doctor doctor = doctorRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found"));
    addressUsecase.delete(doctor.getAddress().getId());
    doctorRepository.delete(doctor);
  }
}