package alfarezyyd.asclepius.model.dto.custodian;

import alfarezyyd.asclepius.model.dto.person.PersonDto;

public interface CustodianDto extends PersonDto {
  String getRelation();

  String getJob();
}
