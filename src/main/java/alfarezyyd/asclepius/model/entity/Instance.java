package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "instances")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Instance {
  @Id
  private String code;
  private String name;
  @Column(name = "telephone_number")
  private String telephoneNumber;
  @OneToOne
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;
  @OneToMany(mappedBy = "instance")
  private List<Patient> patients;
}
