package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "medicines")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Medicine {
  @Id
  private String code;
  private String name;
  private String unit;
  private Integer price;
  private String batch;
  @Column(name = "expired_date")
  private Date expiredDate;
  private Integer stock;
  @ManyToOne
  @JoinColumn(name = "pharmacological_category_id", referencedColumnName = "id")
  private MedicinePharmacologicalCategory medicinePharmacologicalCategory;
  @ManyToOne
  @JoinColumn(name = "dosage_form_id", referencedColumnName = "id")
  private MedicineDosageForm medicineDosageForm;
  @ManyToOne
  @JoinColumn(name = "pharmaceutical_industry_id", referencedColumnName = "id")
  private PharmaceuticalIndustry pharmaceuticalIndustry;
}
