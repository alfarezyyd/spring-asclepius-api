package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.patient.PatientDto;
import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import alfarezyyd.asclepius.model.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface PatientMapper {

  PatientResponse patientEntityIntoPatientResponse(Patient patientEntity);

  @Mapping(target = "birthDate", source = "patientDto.birthDate", qualifiedByName = "stringIntoDateBirthDate")
  @Mapping(target = "disabilities", ignore = true)
  @Mapping(target = "insurances", ignore = true)
  @Mapping(target = "languages", ignore = true)
  @Mapping(target = "custodian", ignore = true)
  @Mapping(target = "instance", ignore = true)
  @Mapping(target = "ethnicity", ignore = true)
  void patientDtoIntoPatientEntity(@MappingTarget Patient patientEntity, PatientDto patientDto);
}
