package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "languages")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Language {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Short id;
  private String name;
  @ManyToMany(mappedBy = "languages")
  private List<Patient> patients;
}
