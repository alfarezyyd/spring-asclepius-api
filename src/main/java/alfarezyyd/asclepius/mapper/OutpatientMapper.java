package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.outpatient.OutpatientDto;
import alfarezyyd.asclepius.model.dto.outpatient.OutpatientResponse;
import alfarezyyd.asclepius.model.entity.Outpatient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = {PatientMapper.class, PolyclinicMapper.class, InsuranceMapper.class, DoctorMapper.class})
public interface OutpatientMapper {
  @Mapping(target = "patient", ignore = true)
  @Mapping(target = "polyclinic", ignore = true)
  @Mapping(target = "insurance", ignore = true)
  @Mapping(target = "doctor", ignore = true)
  OutpatientResponse outpatientEntityIntoOutpatientResponse(Outpatient outpatientEntity);

  @Mapping(target = "patient", qualifiedByName = "simplePatientResponse")
  @Mapping(target = "polyclinic", qualifiedByName = "simplePolyclinicResponse")
  @Mapping(target = "insurance", qualifiedByName = "simpleInsuranceResponse")
  @Mapping(target = "doctor")
  OutpatientResponse outpatientEntityIntoDetailOutpatientResponse(Outpatient outpatientEntity);

  @Mapping(target = "patient", ignore = true)
  @Mapping(target = "polyclinic", ignore = true)
  @Mapping(target = "insurance", ignore = true)
  @Mapping(target = "doctor", ignore = true)
  void outpatientDtoIntoOutpatientEntity(@MappingTarget Outpatient outpatientEntity, OutpatientDto outpatientDto);

}
