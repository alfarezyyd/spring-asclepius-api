package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicDto;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicResponse;
import alfarezyyd.asclepius.model.entity.Polyclinic;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PolyclinicMapper {
  PolyclinicResponse polyclinicEntityIntoPolyclinicResponse(Polyclinic polyclinicEntity);

  void polyclinicDtoIntoPolyclinicEntity(@MappingTarget Polyclinic polyclinicEntity, PolyclinicDto polyclinicDto);

}
