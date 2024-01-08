package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "positions")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Position {
  @Id
  private String code;
  private String name;
}
