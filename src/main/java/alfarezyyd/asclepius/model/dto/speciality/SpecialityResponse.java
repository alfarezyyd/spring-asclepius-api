package alfarezyyd.asclepius.model.dto.speciality;

import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpecialityResponse {
  private String code;
  private String name;
  private String note;
  private List<DoctorResponse> doctors;
}
