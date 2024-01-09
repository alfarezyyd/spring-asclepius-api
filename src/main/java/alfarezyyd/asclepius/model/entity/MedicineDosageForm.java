package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "medicines_dosage_forms")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class MedicineDosageForm {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String description;
  @OneToMany(mappedBy = "medicineDosageForm")
  private List<Medicine> medicines;
}
