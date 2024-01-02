package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.instance.InstanceDto;
import alfarezyyd.asclepius.model.dto.instance.InstanceResponse;
import alfarezyyd.asclepius.model.entity.Instance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = PersonMapper.class)
public interface InstanceMapper {
  @Mapping(target = "patients", ignore = true)
  @Mapping(target = "address", ignore = true)
  InstanceResponse instanceEntityIntoInstanceResponse(Instance instanceEntity);
  InstanceResponse instanceEntityIntoDetailInstanceResponse(Instance instanceEntity);
  void instanceDtoIntoInstanceEntity(@MappingTarget Instance instanceEntity, InstanceDto instanceDto);
}
