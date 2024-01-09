package alfarezyyd.asclepius.model.dto.outpatient.action;

import alfarezyyd.asclepius.model.option.ActionPerformer;

public interface OutpatientActionDto {
  String getActionCode();

  String getRegistrationCode();

  ActionPerformer getActionPerformer();
}
