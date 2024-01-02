package alfarezyyd.asclepius.helper;

import alfarezyyd.asclepius.model.dto.doctor.DoctorDto;
import alfarezyyd.asclepius.model.dto.patient.PatientDto;
import alfarezyyd.asclepius.model.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class General {
  private General() {

  }

  public static void doctorIntegrityCheck(List<Speciality> specialities, List<Polyclinic> polyclinics, DoctorDto doctorDto) {
    if (specialities.size() != doctorDto.getSpecialities().size()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "some speciality not found");
    }

    if (polyclinics.size() != doctorDto.getPolyclinics().size()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "some polyclinics not found");
    }
  }

  public static void patientIntegrityCheck(List<Disability> disabilities, List<Language> languages, List<Insurance> insurances, PatientDto patientDto) {
    if (disabilities.size() != patientDto.getDisabilities().size()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "some disabilities not found");
    }

    if (insurances.size() != patientDto.getInsurances().size()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "some insurances not found");
    }

    if (languages.size() != patientDto.getLanguages().size()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "some languages not found");
    }
  }
}
