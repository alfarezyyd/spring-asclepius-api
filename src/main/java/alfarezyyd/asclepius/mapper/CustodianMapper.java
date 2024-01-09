package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.custodian.CustodianDto;
import alfarezyyd.asclepius.model.dto.custodian.CustodianResponse;
import alfarezyyd.asclepius.model.entity.Custodian;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = {PatientMapper.class, PersonMapper.class})
public interface CustodianMapper {
  @Mapping(target = "patients", ignore = true)
  CustodianResponse custodianEntityIntoCustodianResponse(Custodian custodianEntity);
  @Mapping(target = "patients", qualifiedByName = "simplePatientResponse")
  CustodianResponse custodianEntityIntoDetailCustodianResponse(Custodian custodianEntity);
  void custodianDtoIntoCustodianEntity(@MappingTarget Custodian custodianEntity, CustodianDto custodianDto);

}
