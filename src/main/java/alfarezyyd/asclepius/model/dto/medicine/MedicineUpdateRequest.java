package alfarezyyd.asclepius.model.dto.medicine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class MedicineUpdateRequest implements MedicineDto{
  @NotBlank
  @Size(min = 1, max = 16)
  @JsonIgnore
  private String code;
  @NotBlank
  @Size(min = 1, max = 255)
  private String name;
  @NotBlank
  @Size(min = 1, max = 50)
  private String unit;
  @NotNull
  private Integer price;
  @NotBlank
  @Size(min = 1, max = 50)
  private String batch;
  @JsonProperty("expired_date")
  private Date expiredDate;
  @NotNull
  private Integer stock;
  @JsonProperty("dosage_form")
  @NotNull
  private Integer dosageForm;
  @JsonProperty("pharmacological_category")
  @NotNull
  private Integer pharmacologicalCategory;
  @NotNull
  private Integer supplier;
}
