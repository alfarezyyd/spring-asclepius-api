package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.insurance.InsuranceDto;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceResponse;
import alfarezyyd.asclepius.model.entity.Insurance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(uses = PatientMapper.class)
public interface InsuranceMapper {
  @Named("simpleInsuranceResponse")
  @Mapping(target = "patients", ignore = true)
  InsuranceResponse insuranceEntityIntoInsuranceResponse(Insurance insuranceEntity);
  InsuranceResponse insuranceEntityIntoDetailInsuranceResponse(Insurance insuranceEntity);
  void insuranceDtoIntoInsuranceEntity(@MappingTarget Insurance insuranceEntity, InsuranceDto insuranceDto);
}
