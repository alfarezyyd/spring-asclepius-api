package alfarezyyd.asclepius.model.dto.outpatient.medicine;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutpatientMedicineUpdateRequest implements OutpatientMedicineDto{
  @NotBlank
  @Size(min = 1, max = 16)
  @JsonProperty("medicine_code")
  private String medicineCode;
  @NotBlank
  @Size(min = 1, max = 18)
  @JsonProperty("registration_code")
  private String registrationCode;
  @NotNull
  private Short quantity;
}
