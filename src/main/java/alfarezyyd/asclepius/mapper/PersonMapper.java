package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.person.PersonDto;
import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import alfarezyyd.asclepius.model.entity.Person;

public interface PersonMapper {
  PersonResponse personEntityIntoPersonResponse(Person personEntity);
  Person personDtoIntoPersonEntity(PersonDto personDto);
}
