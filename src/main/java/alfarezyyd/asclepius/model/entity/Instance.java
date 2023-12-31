package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
