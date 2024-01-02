package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.helper.General;
import alfarezyyd.asclepius.mapper.PatientMapper;
import alfarezyyd.asclepius.model.dto.patient.PatientCreateRequest;
import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import alfarezyyd.asclepius.model.dto.patient.PatientUpdateRequest;
import alfarezyyd.asclepius.model.entity.*;
import alfarezyyd.asclepius.repository.*;
import alfarezyyd.asclepius.usecase.AddressUsecase;
import alfarezyyd.asclepius.usecase.PatientUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatientUsecaseImpl implements PatientUsecase {
  private final PatientRepository patientRepository;
  private final AddressUsecase addressUsecase;
  private final ValidationUtil validationUtil;
  private final PatientMapper patientMapper;
  private final DisabilityRepository disabilityRepository;
  private final InsuranceRepository insuranceRepository;
  private final LanguageRepository languageRepository;
  private final EthnicityRepository ethnicityRepository;
  private final InstanceRepository instanceRepository;

  public PatientUsecaseImpl(PatientRepository patientRepository, AddressUsecase addressUsecase, ValidationUtil validationUtil, PatientMapper patientMapper, DisabilityRepository disabilityRepository, InsuranceRepository insuranceRepository, LanguageRepository languageRepository, EthnicityRepository ethnicityRepository, InstanceRepository instanceRepository) {
    this.patientRepository = patientRepository;
    this.addressUsecase = addressUsecase;
    this.validationUtil = validationUtil;
    this.patientMapper = patientMapper;
    this.disabilityRepository = disabilityRepository;
    this.insuranceRepository = insuranceRepository;
    this.languageRepository = languageRepository;
    this.ethnicityRepository = ethnicityRepository;
    this.instanceRepository = instanceRepository;
  }

  @Override
  public List<PatientResponse> findAll() {
    return patientRepository.findAll().stream().map(patientMapper::patientEntityIntoPatientResponse).toList();
  }

  @Override
  public PatientResponse findById(Long personId) {
    Patient searchedPatient = patientRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "patient not found"));
    return patientMapper.patientEntityIntoPatientResponse(searchedPatient);
  }

  @Override
  @Transactional
  public void create(PatientCreateRequest patientCreateRequest) {
    validationUtil.validateRequest(patientCreateRequest);
    Address address = addressUsecase.create(patientCreateRequest.getAddress());
    Patient patient = new Patient();
    patient.setAddress(address);
    patientMapper.patientDtoIntoPatientEntity(patient, patientCreateRequest);
    List<Insurance> insurances = insuranceRepository.findAllById(patientCreateRequest.getInsurances());
    List<Disability> disabilities = disabilityRepository.findAllById(patientCreateRequest.getDisabilities());
    List<Language> languages = languageRepository.findAllById(patientCreateRequest.getLanguages());
    General.patientIntegrityCheck(disabilities, languages, insurances, patientCreateRequest);
    patient.setInsurances(insurances);
    patient.setDisabilities(disabilities);
    patient.setLanguages(languages);
    Ethnicity ethnicity = ethnicityRepository.findById(patientCreateRequest.getEthnicity()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ethnicity not found"));
    patient.setEthnicity(ethnicity);
    Instance instance = instanceRepository.findById(patientCreateRequest.getInstance()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "instance not found"));
    patient.setInstance(instance);
    patientRepository.save(patient);
  }

  @Override
  public void update(PatientUpdateRequest patientUpdateRequest) {
    validationUtil.validateRequest(patientUpdateRequest);
    Patient searchedPatient = patientRepository.findById(patientUpdateRequest.getPersonId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "patient not found"));
    List<Insurance> insurances = insuranceRepository.findAllById(patientUpdateRequest.getInsurances());
    List<Disability> disabilities = disabilityRepository.findAllById(patientUpdateRequest.getDisabilities());
    List<Language> languages = languageRepository.findAllById(patientUpdateRequest.getLanguages());
    General.patientIntegrityCheck(disabilities, languages, insurances, patientUpdateRequest);
    searchedPatient.setInsurances(insurances);
    searchedPatient.setDisabilities(disabilities);
    searchedPatient.setLanguages(languages);
    Ethnicity ethnicity = ethnicityRepository.findById(patientUpdateRequest.getEthnicity()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ethnicity not found"));
    searchedPatient.setEthnicity(ethnicity);
    Instance instance = instanceRepository.findById(patientUpdateRequest.getInstance()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "instance not found"));
    searchedPatient.setInstance(instance);
    patientRepository.save(searchedPatient);

  }

  @Override
  public void delete(Long personId) {
    Patient patient = patientRepository.findById(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "patient not found"));
    patientRepository.delete(patient);
    addressUsecase.delete(patient.getAddress().getId());
  }
}