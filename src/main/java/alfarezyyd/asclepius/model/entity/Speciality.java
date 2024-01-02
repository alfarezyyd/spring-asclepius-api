package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "specialities")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Speciality {
  @Id
  private String code;
  private String name;
  private String note;
  @ManyToMany(mappedBy = "specialities", cascade = CascadeType.PERSIST)
  private List<Doctor> doctors;
}
