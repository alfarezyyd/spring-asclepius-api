package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "procedures")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Procedure {
  @Id
  private String code;
  private String name;
  private String description;
  @Column(name = "patient_preparation")
  private String patientPreparation;
  @Column(name = "procedure_action")
  private String procedureAction;
  @Column(name = "patient_recovery")
  private String patientRecovery;
  private Integer duration;
  @ManyToMany
  @JoinTable(name = "diseases_procedures",
      joinColumns = @JoinColumn(name = "procedure_code", referencedColumnName = "code"),
      inverseJoinColumns = @JoinColumn(name = "disease_code", referencedColumnName = "code"))
  private List<Disease> diseases;
}
