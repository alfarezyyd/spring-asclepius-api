package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ethnicities")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Ethnicity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Short id;
  private String type;
  private String name;
  @OneToMany(mappedBy = "ethnicity")
  private List<Patient> patients;

}
