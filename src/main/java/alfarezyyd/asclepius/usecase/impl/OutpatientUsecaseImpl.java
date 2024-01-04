package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.OutpatientMapper;
import alfarezyyd.asclepius.model.dto.outpatient.OutpatientCreateRequest;
import alfarezyyd.asclepius.model.dto.outpatient.OutpatientResponse;
import alfarezyyd.asclepius.model.entity.*;
import alfarezyyd.asclepius.repository.*;
import alfarezyyd.asclepius.usecase.OutpatientUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OutpatientUsecaseImpl implements OutpatientUsecase {
  private final OutpatientRepository outpatientRepository;
  private final OutpatientMapper outpatientMapper;
  private final PatientRepository patientRepository;
  private final PolyclinicRepository polyclinicRepository;
  private final DoctorRepository doctorRepository;
  private final InsuranceRepository insuranceRepository;
  private final ValidationUtil validationUtil;

  public OutpatientUsecaseImpl(OutpatientRepository outpatientRepository, OutpatientMapper outpatientMapper, PatientRepository patientRepository, PolyclinicRepository polyclinicRepository, DoctorRepository doctorRepository, InsuranceRepository insuranceRepository, ValidationUtil validationUtil) {
    this.outpatientRepository = outpatientRepository;
    this.outpatientMapper = outpatientMapper;
    this.patientRepository = patientRepository;
    this.polyclinicRepository = polyclinicRepository;
    this.doctorRepository = doctorRepository;
    this.insuranceRepository = insuranceRepository;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<OutpatientResponse> findAll() {
    return outpatientRepository.findAll().stream().map(outpatientMapper::outpatientEntityIntoOutpatientResponse).toList();
  }

  @Override
  public OutpatientResponse findById(String registrationCode) {
    Outpatient outpatient = outpatientRepository.findById(registrationCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "registration code of outpatient not found"));
    return outpatientMapper.outpatientEntityIntoDetailOutpatientResponse(outpatient);
  }

  @Override
  public void create(OutpatientCreateRequest outpatientCreateRequest) {
    validationUtil.validateRequest(outpatientCreateRequest);
    Outpatient outpatient = new Outpatient();
    outpatientMapper.outpatientDtoIntoOutpatientEntity(outpatient, outpatientCreateRequest);
    Patient patient = patientRepository.findById(outpatientCreateRequest.getPatient()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "patient not found"));
    Polyclinic polyclinic = polyclinicRepository.findById(outpatientCreateRequest.getPolyclinic()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "polyclinic not found"));
    Doctor doctor = doctorRepository.findById(outpatientCreateRequest.getDoctor()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "doctor not found"));
    Insurance insurance = insuranceRepository.findById(outpatientCreateRequest.getInsurance()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "insurance not found"));
    outpatient.setPatient(patient);
    outpatient.setPolyclinic(polyclinic);
    outpatient.setDoctor(doctor);
    outpatient.setInsurance(insurance);
    outpatient.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
    outpatientRepository.save(outpatient);
  }

  @Override
  public void delete(String registrationCode) {
    if (outpatientRepository.existsById(registrationCode)) {
      outpatientRepository.deleteById(registrationCode);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "registration code of outpatient not found");
    }
  }
}
