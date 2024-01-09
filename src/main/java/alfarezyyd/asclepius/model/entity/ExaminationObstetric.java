package alfarezyyd.asclepius.model.entity;

import alfarezyyd.asclepius.model.option.*;
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
  @Enumerated(EnumType.STRING)
  private Fetus fetus;
  private String location;
  @Enumerated(EnumType.STRING)
  private Contraction contraction;
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
  @Enumerated(EnumType.STRING)
  private Fluxus fluxus;
  @Column(name = "fluor_albus")
  @Enumerated(EnumType.STRING)
  private FluorAlbus fluorAlbus;
  @Column(name = "amniotic_membrane")
  @Enumerated(EnumType.STRING)
  private AmnioticMembrane amnioticMembrane;
  @Column(name = "vulva_condition")
  @Enumerated(EnumType.STRING)
  private VulvaCondition vulvaCondition;
  private String denominator;
  @Enumerated(EnumType.STRING)
  private Direction direction;
  @Column(name = "feto_pelvic_balance")
  @Enumerated(EnumType.STRING)
  private FetoPelvicBalance fetoPelvicBalance;
  @OneToOne
  @PrimaryKeyJoinColumn(name = "examination_id", referencedColumnName = "id")
  private Examination examination;
}
