package alfarezyyd.asclepius.model.dto.medicine.pharmacological.categories;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicinePharmacologicalCategoryCreateRequest implements MedicinePharmacologicalCategoryDto {
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
  @NotBlank
  private String description;
}
