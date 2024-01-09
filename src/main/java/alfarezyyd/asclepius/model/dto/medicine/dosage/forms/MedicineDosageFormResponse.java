package alfarezyyd.asclepius.model.dto.medicine.dosage.forms;

import alfarezyyd.asclepius.model.dto.medicine.MedicineResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MedicineDosageFormResponse {
  private Integer id;
  private String name;
  private String description;
  private List<MedicineResponse> medicines;
}
