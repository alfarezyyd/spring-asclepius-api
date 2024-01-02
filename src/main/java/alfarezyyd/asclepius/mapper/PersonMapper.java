package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.person.PersonDto;
import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import alfarezyyd.asclepius.model.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.sql.Date;

@Mapper(uses = AddressMapper.class)
public interface PersonMapper {
  PersonResponse personEntityIntoPersonResponse(Person personEntity);

  @Mapping(target = "birthDate", source = "personDto.birthDate", qualifiedByName = "stringIntoDateBirthDate")
  Person personDtoIntoPersonEntity(PersonDto personDto);

  @Named("stringIntoDateBirthDate")
  static Date stringIntoDateBirthDate(String birthDate) {
    return Date.valueOf(birthDate);
  }
}
