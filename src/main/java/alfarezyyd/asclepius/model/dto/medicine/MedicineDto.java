package alfarezyyd.asclepius.model.dto.medicine;

import java.sql.Date;

public interface MedicineDto {

  String getCode();

  String getName();

  String getUnit();

  Integer getPrice();

  String getBatch();

  Date getExpiredDate();

  Integer getStock();

  Integer getDosageForm();

  Integer getPharmacologicalCategory();

  Integer getSupplier();
}
