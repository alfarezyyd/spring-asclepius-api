package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.position.PositionDto;
import alfarezyyd.asclepius.model.dto.position.PositionResponse;
import alfarezyyd.asclepius.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper
public interface PositionMapper {
  @Named("simplePositionResponse")
  @Mapping(target = "employees", ignore = true)
  PositionResponse positionEntityIntoPositionResponse(Position positionEntity);

  PositionResponse positionEntityIntoDetailPositionResponse(Position positionEntity);

  void positionDtoIntoPositionEntity(@MappingTarget Position positionEntity, PositionDto positionDto);
}
