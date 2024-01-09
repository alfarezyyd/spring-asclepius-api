package alfarezyyd.asclepius.model.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "actions_categories")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ActionCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  @OneToMany(mappedBy = "category")
  private List<Action> actions;
}
