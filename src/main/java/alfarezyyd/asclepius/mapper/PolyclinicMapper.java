package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicDto;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicResponse;
import alfarezyyd.asclepius.model.entity.Polyclinic;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = DoctorMapper.class)
public interface PolyclinicMapper {
  @Named("simplePolyclinicResponse")
  @Mapping(target = "doctors", ignore = true)
  PolyclinicResponse polyclinicEntityIntoPolyclinicResponse(Polyclinic polyclinicEntity);

  PolyclinicResponse polyclinicEntityIntoDetailPolyclinicResponse(Polyclinic polyclinicEntity);

  void polyclinicDtoIntoPolyclinicEntity(@MappingTarget Polyclinic polyclinicEntity, PolyclinicDto polyclinicDto);

}
