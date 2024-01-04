package alfarezyyd.asclepius.model.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "outpatients")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Outpatient {
  @Id
  private String registrationCode;
  private Timestamp registrationDate;
  @OneToOne
  @JoinColumn(name = "doctor_id", referencedColumnName = "people_id")
  private Doctor doctor;
  @OneToOne
  @JoinColumn(name = "polyclinic_code", referencedColumnName = "code")
  private Polyclinic polyclinic;
  @OneToOne
  @JoinColumn(name = "insurance_code", referencedColumnName = "code")
  private Insurance insurance;
  @OneToOne
  @JoinColumn(name = "patient_id", referencedColumnName = "people_id")
  private Patient patient;
}
