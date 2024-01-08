package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.employee.EmployeeCreateRequest;
import alfarezyyd.asclepius.model.dto.employee.EmployeeResponse;
import alfarezyyd.asclepius.model.dto.employee.EmployeeUpdateRequest;

import java.util.List;

public interface EmployeeUsecase {
  List<EmployeeResponse> findAll();
  EmployeeResponse findById(Long personId);
  void create(EmployeeCreateRequest employeeCreateRequest);
  void update(EmployeeUpdateRequest employeeUpdateRequest);
  void delete(Long personId);
}
