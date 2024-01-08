package alfarezyyd.asclepius.model.dto.position;

import alfarezyyd.asclepius.model.dto.employee.EmployeeResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PositionResponse {
  private String code;
  private String name;
  private List<EmployeeResponse> employees;
}
