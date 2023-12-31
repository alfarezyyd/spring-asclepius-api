package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Patient extends Person {
  @Column(name = "medical_record_code")
  private String medicalRecordCode;
  @Column(name = "mother_name")
  private String motherName;
  @Column(name = "registration_date")
  private String registrationDate;
  private String job;
  @Column(name = "employee_code")
  private String employeeCode;
  @ManyToOne
  @JoinColumn(name = "ethnic_id", referencedColumnName = "id")
  private Ethnicity ethnicity;
  @ManyToMany(mappedBy = "patients")
  private List<Disability> disabilities;
  @ManyToMany(mappedBy = "patients")
  private List<Insurance> insurances;
  @ManyToMany(mappedBy = "patients")
  private List<Languages> languages;
  @ManyToOne
  @JoinColumn(name = "custodian_id", referencedColumnName = "people_id")
  private Custodian custodian;
}
