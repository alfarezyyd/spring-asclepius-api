package alfarezyyd.asclepius.model.entity;

import alfarezyyd.asclepius.model.embeddable.OutpatientActionPK;
import alfarezyyd.asclepius.model.option.ActionPerformer;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "outpatients_actions")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class OutpatientAction {
  @EmbeddedId
  private OutpatientActionPK outpatientActionPK;
  @MapsId("medicineCode")
  @ManyToOne
  @JoinColumn(name = "action_code", referencedColumnName = "code")
  private Action action;
  @MapsId("registrationCode")
  @ManyToOne
  @JoinColumn(name = "registration_code", referencedColumnName = "registration_code")
  private Outpatient outpatient;
  @Enumerated(EnumType.STRING)
  @Column(name = "action_performer")
  private ActionPerformer actionPerformer;
}
