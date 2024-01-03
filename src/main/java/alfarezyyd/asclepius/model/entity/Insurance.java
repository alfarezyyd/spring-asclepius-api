package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "insurances")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Insurance {
  @Id
  private String code;
  private String name;
  private String company;
  @Column(name = "telephone_number")
  private String telephoneNumber;
  private String representative;
  @ManyToMany(mappedBy = "insurances")
  private List<Patient> patients;
}
