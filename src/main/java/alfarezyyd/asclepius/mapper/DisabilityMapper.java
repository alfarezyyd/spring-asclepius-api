package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.disability.DisabilityDto;
import alfarezyyd.asclepius.model.dto.disability.DisabilityResponse;
import alfarezyyd.asclepius.model.entity.Disability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = PatientMapper.class)
public interface DisabilityMapper {
  @Mapping(target = "patients", ignore = true)
  DisabilityResponse disabilityEntityIntoDisabilityResponse(Disability disabilityEntity);
  @Mapping(target = "patients", qualifiedByName = "simplePatientResponse")
  DisabilityResponse disabilityEntityIntoDetailDisabilityResponse(Disability disabilityEntity);
  void disabilityDtoIntoDisabilityEntity(@MappingTarget Disability disabilityEntity, DisabilityDto disabilityDto);
}
