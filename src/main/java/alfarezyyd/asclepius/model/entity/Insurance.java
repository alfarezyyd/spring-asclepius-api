package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "insurances")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Insurance {
  @Id
  private String code;
  private String name;
  private String company;
  @Column(name = "telephone_number")
  private String telephoneNumber;
  private String representative;
  @ManyToMany
  @JoinTable(name = "patients_insurances",
      joinColumns = @JoinColumn(name = "insurance_code", referencedColumnName = "code"),
      inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "people_id"))
  private List<Patient> patients;
}
