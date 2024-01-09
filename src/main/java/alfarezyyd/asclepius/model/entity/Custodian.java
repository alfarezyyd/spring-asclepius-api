package alfarezyyd.asclepius.model.entity;


import alfarezyyd.asclepius.model.option.Relation;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "custodians")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Custodian extends Person {
  @Enumerated(EnumType.STRING)
  private Relation relation;
  private String job;
  @OneToMany(mappedBy = "custodian")
  private List<Patient> patients;
}
