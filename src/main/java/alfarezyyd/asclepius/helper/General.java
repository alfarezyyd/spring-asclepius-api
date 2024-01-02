package alfarezyyd.asclepius.helper;

import alfarezyyd.asclepius.model.dto.doctor.DoctorDto;
import alfarezyyd.asclepius.model.entity.Polyclinic;
import alfarezyyd.asclepius.model.entity.Speciality;
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
}
