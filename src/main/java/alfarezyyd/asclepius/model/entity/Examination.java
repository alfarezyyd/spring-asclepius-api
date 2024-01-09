package alfarezyyd.asclepius.model.entity;

import alfarezyyd.asclepius.model.option.Consciousness;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "examinations")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Examination {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String subject;
  private String object;
  private Byte temperature;
  @Column(name = "tension_diastolic")
  private Byte tensionDiastolic;
  @Column(name = "tension_systolic")
  private Byte tensionSystolic;
  private Short weight;
  private Short height;
  @Column(name = "respiration_rate")
  private Short respirationRate;
  private Short pulse;
  @Column(name = "oxygen_saturation")
  private Short oxygenSaturation;
  @Column(name = "glasgow_coma_scale")
  private Byte glasgowComaScale;
  @Enumerated(EnumType.STRING)
  private Consciousness consciousness;
  private String allergy;
  private String assessment;
  private String plan;
  private String instruction;
  private String evaluation;
  private String note;
  @OneToOne
  @JoinColumn(name = "registration_code", referencedColumnName = "registration_code")
  private Outpatient outpatient;
  @OneToOne(mappedBy = "examination")
  private ExaminationObstetric examinationObstetric;
  @OneToOne(mappedBy = "examination")
  private ExaminationGynecological examinationGynecological;
}
