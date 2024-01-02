package alfarezyyd.asclepius.model.dto.language;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageCreateRequest implements LanguageDto{
  @NotBlank
  @Size(min = 1, max = 50)
  private String name;
}
