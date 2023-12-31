package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.speciality.SpecialityDto;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityResponse;
import alfarezyyd.asclepius.model.entity.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
  SpecialityResponse specialityEntityIntoSpecialityResponse(Speciality specialityEntity);

  void specialityDtoIntoSpecialityEntity(@MappingTarget Speciality specialityEntity, SpecialityDto specialityDto);

}
