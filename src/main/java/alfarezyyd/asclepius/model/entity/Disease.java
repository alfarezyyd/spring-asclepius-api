package alfarezyyd.asclepius.model.entity;

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
  private String riskPrognosis;
  @Column(name = "contagious_status")
  private String contagiousStatus;
  private String symptom;
  @ManyToMany(mappedBy = "disease")
  private List<Procedure> procedures;
}
