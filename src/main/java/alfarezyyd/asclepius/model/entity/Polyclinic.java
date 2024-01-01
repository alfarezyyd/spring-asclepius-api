package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "polyclinics")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Polyclinic {
  @Id
  private String code;
  private String name;
  private String location;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "doctors_polyclinics",
      joinColumns = @JoinColumn(name = "polyclinic_code", referencedColumnName = "code"),
      inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "people_id"))
  private List<Doctor> doctors;
}
