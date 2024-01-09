package alfarezyyd.asclepius.model.dto.medicine;

import alfarezyyd.asclepius.model.dto.medicine.dosage.forms.MedicineDosageFormResponse;
import alfarezyyd.asclepius.model.dto.medicine.pharmacological.categories.MedicinePharmacologicalCategoryResponse;
import alfarezyyd.asclepius.model.dto.medicine.supplier.MedicineSupplierResponse;
import alfarezyyd.asclepius.model.dto.outpatient.medicine.OutpatientMedicineResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MedicineResponse {
  private String code;
  private String name;
  private String unit;
  private Integer price;
  private String batch;
  @JsonProperty("expired_date")
  private Date expiredDate;
  private Integer stock;
  private MedicinePharmacologicalCategoryResponse pharmacologicalCategory;
  private MedicineDosageFormResponse dosageForm;
  private MedicineSupplierResponse supplier;
  private List<OutpatientMedicineResponse> outpatientMedicines;
}
