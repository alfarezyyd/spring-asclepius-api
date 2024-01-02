package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.helper.General;
import alfarezyyd.asclepius.mapper.AddressMapper;
import alfarezyyd.asclepius.mapper.DoctorMapper;
import alfarezyyd.asclepius.model.dto.doctor.DoctorCreateRequest;
import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.dto.doctor.DoctorUpdateRequest;
import alfarezyyd.asclepius.model.entity.Address;
import alfarezyyd.asclepius.model.entity.Doctor;
import alfarezyyd.asclepius.model.entity.Polyclinic;
import alfarezyyd.asclepius.model.entity.Speciality;
import alfarezyyd.asclepius.repository.DoctorRepository;
import alfarezyyd.asclepius.repository.PolyclinicRepository;
import alfarezyyd.asclepius.repository.SpecialityRepository;
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
  private final SpecialityRepository specialityRepository;
  private final PolyclinicRepository polyclinicRepository;

  public DoctorUsecaseImpl(DoctorRepository doctorRepository, AddressUsecase addressUsecase, ValidationUtil validationUtil, DoctorMapper doctorMapper, AddressMapper addressMapper, SpecialityRepository specialityRepository, PolyclinicRepository polyclinicRepository) {
    this.doctorRepository = doctorRepository;
    this.addressUsecase = addressUsecase;
    this.validationUtil = validationUtil;
    this.doctorMapper = doctorMapper;
    this.addressMapper = addressMapper;
    this.specialityRepository = specialityRepository;
    this.polyclinicRepository = polyclinicRepository;
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
    List<Speciality> specialities = specialityRepository.findAllById(doctorCreateRequest.getSpecialities());
    List<Polyclinic> polyclinics = polyclinicRepository.findAllById(doctorCreateRequest.getPolyclinics());
    General.doctorIntegrityCheck(specialities, polyclinics, doctorCreateRequest);
    doctor.setSpecialities(specialities);
    doctor.setPolyclinics(polyclinics);
    doctorRepository.save(doctor);
  }

  @Override
  public void update(DoctorUpdateRequest doctorUpdateRequest) {
    validationUtil.validateRequest(doctorUpdateRequest);
    Doctor searchedDoctor = doctorRepository.findById(doctorUpdateRequest.getPersonId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found"));
    List<Speciality> specialities = specialityRepository.findAllById(doctorUpdateRequest.getSpecialities());
    List<Polyclinic> polyclinics = polyclinicRepository.findAllById(doctorUpdateRequest.getPolyclinics());
    addressUsecase.update(doctorUpdateRequest.getAddress(), searchedDoctor.getAddress());
    doctorMapper.doctorDtoIntoDoctorEntity(searchedDoctor, doctorUpdateRequest);
    General.doctorIntegrityCheck(specialities, polyclinics, doctorUpdateRequest);
    searchedDoctor.setPolyclinics(polyclinics);
    searchedDoctor.setSpecialities(specialities);
    doctorRepository.save(searchedDoctor);

  }

  @Override
  public void delete(Long personId) {
    Doctor doctor = doctorRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found"));
    doctorRepository.delete(doctor);
    addressUsecase.delete(doctor.getAddress().getId());
  }
}