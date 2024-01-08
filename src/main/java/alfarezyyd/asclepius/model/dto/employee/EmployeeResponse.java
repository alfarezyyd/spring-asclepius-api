package alfarezyyd.asclepius.model.dto.employee;

import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import alfarezyyd.asclepius.model.entity.Position;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse extends PersonResponse {
  private Position position;
}
