package alfarezyyd.asclepius.model.dto.medicine.pharmacological.categories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicinePharmacologicalCategoryUpdateRequest implements MedicinePharmacologicalCategoryDto {
  @NotNull
  @JsonIgnore
  private Integer id;
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
  @NotBlank
  private String description;
}
