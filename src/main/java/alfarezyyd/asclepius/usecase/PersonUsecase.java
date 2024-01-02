package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.person.PersonCreateRequest;
import alfarezyyd.asclepius.model.dto.person.PersonResponse;
import alfarezyyd.asclepius.model.dto.person.PersonUpdateRequest;
import alfarezyyd.asclepius.model.entity.Person;

public interface PersonUsecase {

  PersonResponse findById(Long personId);

  Person create(PersonCreateRequest personCreateRequest);

  void update(PersonUpdateRequest personUpdateRequest);

  void delete(Long personId);
}
