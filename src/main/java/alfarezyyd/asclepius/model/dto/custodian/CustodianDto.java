package alfarezyyd.asclepius.model.dto.custodian;

import alfarezyyd.asclepius.model.dto.person.PersonDto;
import alfarezyyd.asclepius.model.option.Relation;

public interface CustodianDto extends PersonDto {
  Relation getRelation();

  String getJob();
}
