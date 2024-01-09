package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.action.ActionDto;
import alfarezyyd.asclepius.model.dto.action.ActionResponse;
import alfarezyyd.asclepius.model.entity.Action;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper
public interface ActionMapper {
  @Named("simpleActionResponse")
  @Mapping(target = "category", ignore = true)
  ActionResponse actionEntityIntoActionResponse(Action actionEntity);

  ActionResponse actionEntityIntoDetailActionResponse(Action actionEntity);

  @Mapping(target = "category", ignore = true)
  void actionDtoIntoActionEntity(@MappingTarget Action actionEntity, ActionDto actionDto);
}
