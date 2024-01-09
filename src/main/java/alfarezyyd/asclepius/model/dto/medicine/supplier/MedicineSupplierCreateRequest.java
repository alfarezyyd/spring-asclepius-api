package alfarezyyd.asclepius.model.dto.medicine.supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineSupplierCreateRequest implements MedicineSupplierDto {
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
  @NotBlank
  private String description;
}
