package alfarezyyd.asclepius.model.dto.language;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageUpdateRequest implements LanguageDto {
  @NotNull
  @JsonIgnore
  private Short id;
  @NotBlank
  @Size(min = 1, max = 50)
  private String name;
}
