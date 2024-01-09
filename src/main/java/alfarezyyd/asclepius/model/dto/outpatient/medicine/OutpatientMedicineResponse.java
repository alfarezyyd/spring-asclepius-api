package alfarezyyd.asclepius.model.dto.outpatient.medicine;

import alfarezyyd.asclepius.model.entity.Medicine;
import alfarezyyd.asclepius.model.entity.Outpatient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutpatientMedicineResponse {
  private Medicine medicine;
  private Outpatient outpatient;
  private Short quantity;
}
