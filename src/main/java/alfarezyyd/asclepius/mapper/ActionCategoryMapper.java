package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryDto;
import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryResponse;
import alfarezyyd.asclepius.model.entity.ActionCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = ActionMapper.class)
public interface ActionCategoryMapper {

  @Mapping(target = "actions", ignore = true)
  ActionCategoryResponse actionCategoryEntityIntoActionCategoryResponse(ActionCategory actionCategoryEntity);

  @Mapping(target = "actions", qualifiedByName = "simpleActionResponse")
  ActionCategoryResponse actionCategoryEntityIntoDetailActionCategoryResponse(ActionCategory actionCategoryEntity);

  @Mapping(target = "actions", ignore = true)
  void actionCategoryDtoIntoActionCategoryEntity(@MappingTarget ActionCategory actionCategoryEntity, ActionCategoryDto actionCategoryDto);
}
