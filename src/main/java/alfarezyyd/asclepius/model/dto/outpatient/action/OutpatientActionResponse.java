package alfarezyyd.asclepius.model.dto.outpatient.action;

import alfarezyyd.asclepius.model.entity.Action;
import alfarezyyd.asclepius.model.entity.Outpatient;
import alfarezyyd.asclepius.model.option.ActionPerformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutpatientActionResponse {
  private Action action;
  private Outpatient outpatient;
  @JsonProperty("action_performer")
  private ActionPerformer actionPerformer;
}
