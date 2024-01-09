package alfarezyyd.asclepius.model.dto.medicine.supplier;

import alfarezyyd.asclepius.model.dto.medicine.MedicineResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MedicineSupplierResponse {
  private Integer id;
  private String name;
  private String description;
  private List<MedicineResponse> medicines;
}
