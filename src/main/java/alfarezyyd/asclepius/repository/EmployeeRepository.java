package alfarezyyd.asclepius.repository;

import alfarezyyd.asclepius.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
