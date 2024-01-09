package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
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
  private Date registrationDate;
  private String job;
  @Column(name = "employee_code")
  private String employeeCode;
  @ManyToOne
  @JoinColumn(name = "ethnic_id", referencedColumnName = "id")
  private Ethnicity ethnicity;
  @ManyToMany
  @JoinTable(name = "patients_disabilities",
      joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "disability_id", referencedColumnName = "id"))
  private List<Disability> disabilities;
  @ManyToMany
  @JoinTable(name = "patients_insurances",
      joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "insurance_code", referencedColumnName = "code"))
  private List<Insurance> insurances;
  @ManyToMany
  @JoinTable(name = "patients_languages",
      joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "id"))
  private List<Language> languages;
  @ManyToOne
  @JoinColumn(name = "custodian_id", referencedColumnName = "person_id")
  private Custodian custodian;
  @ManyToOne
  @JoinColumn(name = "instance_code", referencedColumnName = "code")
  private Instance instance;
}
