package alfarezyyd.asclepius.model.dto.medicine.pharmacological.categories;

import alfarezyyd.asclepius.model.dto.medicine.MedicineResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MedicinePharmacologicalCategoryResponse {
  private Integer id;
  private String name;
  private String description;
  private List<MedicineResponse> medicines;
}
