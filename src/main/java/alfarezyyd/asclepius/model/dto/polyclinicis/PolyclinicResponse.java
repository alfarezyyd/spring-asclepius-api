package alfarezyyd.asclepius.model.dto.polyclinicis;

import alfarezyyd.asclepius.model.entity.Doctor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PolyclinicResponse {
  private String code;
  private String name;
  private String location;
  private List<Doctor> doctors;
}
