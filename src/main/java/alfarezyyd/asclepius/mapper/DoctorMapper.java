package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.doctor.DoctorDto;
import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface DoctorMapper {

  DoctorResponse doctorEntityIntoDoctorResponse(Doctor doctorEntity);

  @Mapping(target = "birthDate", source = "doctorDto.birthDate", qualifiedByName = "stringIntoDateBirthDate")
  void doctorDtoIntoDoctorEntity(@MappingTarget Doctor doctorEntity, DoctorDto doctorDto);
}
