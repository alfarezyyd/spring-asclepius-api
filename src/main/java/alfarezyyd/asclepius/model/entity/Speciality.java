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
  private String text;
  @ManyToMany
  @JoinTable(name = "doctors_specialities",
      joinColumns = @JoinColumn(name = "speciality_code", referencedColumnName = "code"),
      inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "people_id"))
  private List<Doctor> doctors;
}
