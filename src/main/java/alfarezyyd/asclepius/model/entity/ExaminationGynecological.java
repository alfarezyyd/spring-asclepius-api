package alfarezyyd.asclepius.model.entity;

import alfarezyyd.asclepius.model.option.FluorAlbus;
import alfarezyyd.asclepius.model.option.Fluxus;
import alfarezyyd.asclepius.model.option.Mobility;
import alfarezyyd.asclepius.model.option.Tenderness;
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
  @Enumerated(EnumType.STRING)
  private Fluxus fluxus;
  @Column(name = "fluor_albus")
  @Enumerated(EnumType.STRING)
  private FluorAlbus fluorAlbus;
  @Column(name = "portio_inspeculo")
  private String portioInspeculo;
  @Column(name = "sondage_inspeculo")
  private String sondageInspeculo;
  @Column(name = "internal_portio_inspeculo")
  private String internalPortioInspeculo;
  private String shape;
  @Column(name = "uterine_cavity")
  private String uterineCavity;
  @Enumerated(EnumType.STRING)
  private Mobility mobility;
  private String size;
  @Enumerated(EnumType.STRING)
  private Tenderness tenderness;
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
