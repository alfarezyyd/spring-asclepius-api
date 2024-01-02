package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.speciality.SpecialityDto;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityResponse;
import alfarezyyd.asclepius.model.entity.Speciality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
  SpecialityResponse specialityEntityIntoSpecialityResponse(Speciality specialityEntity);

  @Mapping(target = "doctors", ignore = true)
  SpecialityResponse specialityEntityIntoSpecialityResponseWithoutDoctors(Speciality specialityEntity);
  void specialityDtoIntoSpecialityEntity(@MappingTarget Speciality specialityEntity, SpecialityDto specialityDto);

}
