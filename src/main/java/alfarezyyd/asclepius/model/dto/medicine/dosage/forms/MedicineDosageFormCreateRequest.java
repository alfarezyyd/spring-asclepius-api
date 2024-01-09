package alfarezyyd.asclepius.model.dto.medicine.dosage.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineDosageFormCreateRequest implements MedicineDosageFormDto {
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
  @NotBlank
  private String description;
}
