package alfarezyyd.asclepius.model.dto.disease.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiseaseCategoryCreateRequest implements DiseaseCategoryDto {
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
}
