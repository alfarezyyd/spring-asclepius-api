package alfarezyyd.asclepius.model.dto.custodian;

import alfarezyyd.asclepius.model.dto.person.PersonUpdateRequest;
import alfarezyyd.asclepius.model.option.Relation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustodianUpdateRequest extends PersonUpdateRequest implements CustodianDto{
  @NotBlank
  private Relation relation;
  @NotBlank
  @Size(min = 1, max = 50)
  private String job;
}
