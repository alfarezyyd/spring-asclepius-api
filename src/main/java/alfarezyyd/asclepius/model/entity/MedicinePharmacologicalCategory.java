package alfarezyyd.asclepius.model.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "medicines_pharmacological_categories")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class MedicinePharmacologicalCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String description;
  @OneToMany(mappedBy = "medicinePharmacologicalCategory")
  private List<Medicine> medicines;
}
