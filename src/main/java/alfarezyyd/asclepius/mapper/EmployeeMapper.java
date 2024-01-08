package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.employee.EmployeeDto;
import alfarezyyd.asclepius.model.dto.employee.EmployeeResponse;
import alfarezyyd.asclepius.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper
public interface EmployeeMapper {
  @Named("simpleEmployeeResponse")
  @Mapping(target = "position", ignore = true)
  EmployeeResponse employeeEntityIntoEmployeeResponse(Employee employeeEntity);

  EmployeeResponse employeeEntityIntoDetailEmployeeResponse(Employee employeeEntity);

  @Mapping(target = "position", ignore = true)
  void employeeDtoIntoEmployeeEntity(@MappingTarget Employee employeeEntity, EmployeeDto employeeDto);

}
