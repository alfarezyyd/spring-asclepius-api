package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityDto;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityResponse;
import alfarezyyd.asclepius.model.entity.Ethnicity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = {PersonMapper.class, PatientMapper.class})
public interface EthnicityMapper {
  @Mapping(target = "patients", ignore = true)
  EthnicityResponse ethnicityEntityIntoEthnicityResponse(Ethnicity ethnicityEntity);
  EthnicityResponse ethnicityEntityIntoDetailEthnicityResponse(Ethnicity ethnicityEntity);
  void ethnicityDtoIntoEthnicityEntity(@MappingTarget Ethnicity ethnicityEntity, EthnicityDto ethnicityDto);
}
