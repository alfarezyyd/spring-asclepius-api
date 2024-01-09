package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "examinations_obstetrics")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ExaminationObstetric {
  @Id
  @Column(name = "examination_id")
  private Long examinationId;
  @Column(name = "uterine_fundus_height")
  private Byte uterineFundusHeight;
  private String fetus;
  private String location;
  private String contraction;
  private Short quality;
  private String vulva;
  @Column(name = "portio_inspeculo")
  private String portioInspeculo;
  @Column(name = "pelvis_lower_part")
  private Byte pelvisLowerPart;
  @Column(name = "cervical_opening")
  private String cervicalOpening;
  @Column(name = "cervical_descent")
  private String cervicalDescent;
  private String fluxus;
  @Column(name = "fluor_albus")
  private String fluorAlbus;
  @Column(name = "amniotic_membrane")
  private String amnioticMembrane;
  @Column(name = "vulva_condition")
  private String vulvaCondition;
  private String denominator;
  private String direction;
  @Column(name = "feto_pelvic_balance")
  private String fetoPelvicBalance;
  @OneToOne
  @PrimaryKeyJoinColumn(name = "examination_id", referencedColumnName = "id")
  private Examination examination;
}
