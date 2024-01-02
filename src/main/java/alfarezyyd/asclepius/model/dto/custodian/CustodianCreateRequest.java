package alfarezyyd.asclepius.model.dto.custodian;

import alfarezyyd.asclepius.constraint.RelationEnumConstraint;
import alfarezyyd.asclepius.model.dto.person.PersonCreateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustodianCreateRequest extends PersonCreateRequest implements CustodianDto{
  @RelationEnumConstraint
  @NotBlank
  private String relation;
  @NotBlank
  @Size(min = 1, max = 50)
  private String job;
}
