package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "examinations_gynecologicals")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ExaminationGynecological {
  @Id
  @Column(name = "examination_id")
  private Long examinationId;
  private String inspection;
  private String vulva;
  private String inspeculo;
  private String fluxus;
  @Column(name = "fluor_albus")
  private String fluorAlbus;
  @Column(name = "portio_inspeculo")
  private String portioInspeculo;
  @Column(name = "sondage_inspeculo")
  private String sondageInspeculo;
  @Column(name = "internal_portio_inspeculo")
  private String internalPortioInspeculo;
  private String shape;
  @Column(name = "uterine_cavity")
  private String uterineCavity;
  private String mobility;
  private String size;
  private String tenderness;
  @Column(name = "right_adnexa")
  private String rightAdnexa;
  @Column(name = "left_adnexa")
  private String leftAdnexa;
  @Column(name = "douglas_cavity")
  private String douglasCavity;
  @OneToOne
  @PrimaryKeyJoinColumn(name = "examination_id", referencedColumnName = "id")
  private Examination examination;
}
