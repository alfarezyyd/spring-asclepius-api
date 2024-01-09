package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
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
  private String patientPreparation;
  private String procedureAction;
  private String patientRecovery;
  private Time duration;
  @ManyToMany
  @JoinTable(name = "diseases_procedures",
      joinColumns = @JoinColumn(name = "procedure_code", referencedColumnName = "code"),
      inverseJoinColumns = @JoinColumn(name = "disease_code", referencedColumnName = "code"))
  private List<Disease> diseases;
}
