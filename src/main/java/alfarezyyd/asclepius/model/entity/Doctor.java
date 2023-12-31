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
  @ManyToMany(mappedBy = "doctors")
  private List<Speciality> specialities;
  @ManyToMany(mappedBy = "doctors")
  private List<Polyclinic> polyclinics;
}
