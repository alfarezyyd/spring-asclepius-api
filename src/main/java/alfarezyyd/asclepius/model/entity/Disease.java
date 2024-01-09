package alfarezyyd.asclepius.model.entity;

import alfarezyyd.asclepius.model.option.ContagiousStatus;
import alfarezyyd.asclepius.model.option.RiskPrognosis;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "diseases")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Disease {
  @Id
  private String code;
  private String name;
  private String description;
  private String complication;
  private String indication;
  @Column(name = "risk_prognosis")
  @Enumerated(EnumType.STRING)
  private RiskPrognosis riskPrognosis;
  @Column(name = "contagious_status")
  @Enumerated(EnumType.STRING)
  private ContagiousStatus contagiousStatus;
  private String symptom;
  @ManyToMany(mappedBy = "diseases")
  private List<Procedure> procedures;
}
