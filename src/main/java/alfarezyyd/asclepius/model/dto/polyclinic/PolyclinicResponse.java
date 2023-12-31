package alfarezyyd.asclepius.model.dto.polyclinic;

import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PolyclinicResponse {
  private String code;
  private String name;
  private String location;
  private List<DoctorResponse> doctors;
}
