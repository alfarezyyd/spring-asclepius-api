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
  @Mapping(target = "specialities", ignore = true)
  @Mapping(target = "polyclinics", ignore = true)
  void patientDtoIntoPatientEntity(@MappingTarget Patient patientEntity, PatientDto patientDto);
}
