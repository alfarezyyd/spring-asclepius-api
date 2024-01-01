package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.DoctorMapper;
import alfarezyyd.asclepius.model.dto.doctor.DoctorCreateRequest;
import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.dto.doctor.DoctorUpdateRequest;
import alfarezyyd.asclepius.model.entity.Doctor;
import alfarezyyd.asclepius.repository.DoctorRepository;
import alfarezyyd.asclepius.usecase.DoctorUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class DoctorUsecaseImpl implements DoctorUsecase {
  private final DoctorRepository doctorRepository;
  private final ValidationUtil validationUtil;
  private final DoctorMapper doctorMapper;

  public DoctorUsecaseImpl(DoctorRepository doctorRepository, ValidationUtil validationUtil, DoctorMapper doctorMapper) {
    this.doctorRepository = doctorRepository;
    this.validationUtil = validationUtil;
    this.doctorMapper = doctorMapper;
  }

  @Override
  public List<DoctorResponse> findAll() {
    return doctorRepository.findAll().stream().map(doctorMapper::doctorEntityIntoDoctorResponse).toList();
  }

  @Override
  public DoctorResponse findById(Long doctorId) {
    Doctor searchedDoctor = doctorRepository.findById(doctorId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found"));
    return doctorMapper.doctorEntityIntoDoctorResponse(searchedDoctor);
  }

  @Override
  public void create(DoctorCreateRequest doctorCreateRequest) {
    validationUtil.validateRequest(doctorCreateRequest);
    Doctor doctor = new Doctor();
    doctorMapper.doctorDtoIntoDoctorEntity(doctor, doctorCreateRequest);
    doctorRepository.save(doctor);
  }

  @Override
  public void update(DoctorUpdateRequest doctorUpdateRequest) {
    validationUtil.validateRequest(doctorUpdateRequest);
    Doctor searchedDoctor = doctorRepository.findById(doctorUpdateRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found"));
    doctorMapper.doctorDtoIntoDoctorEntity(searchedDoctor, doctorUpdateRequest);
    doctorRepository.save(searchedDoctor);
  }

  @Override
  public void delete(Long doctorId) {
    if (doctorRepository.existsById(doctorId)) {
      doctorRepository.deleteById(doctorId);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found");
    }
  }
}
