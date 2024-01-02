package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Doctor extends Person {
  private String code;
  private String alumnus;
  @Column(name = "practice_permit_number")
  private String practicePermitNumber;
  @ManyToMany
  @JoinTable(name = "doctors_specialities",
      inverseJoinColumns = @JoinColumn(name = "speciality_code", referencedColumnName = "code"),
      joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "people_id"))
  private List<Speciality> specialities;
  @ManyToMany
  @JoinTable(name = "doctors_polyclinics",
      inverseJoinColumns = @JoinColumn(name = "polyclinic_code", referencedColumnName = "code"),
      joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "people_id"))
  private List<Polyclinic> polyclinics;
}
