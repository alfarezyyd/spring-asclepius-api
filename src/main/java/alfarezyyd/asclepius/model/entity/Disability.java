package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "disabilities")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Disability {
  @Id
  private Long id;
  private String name;
  @ManyToMany
  @JoinTable(name = "patients_disabilities",
  joinColumns = @JoinColumn(name = "disabilities_id", referencedColumnName = "id"),
  inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "people_id"))
  private List<Patient> patients;
}