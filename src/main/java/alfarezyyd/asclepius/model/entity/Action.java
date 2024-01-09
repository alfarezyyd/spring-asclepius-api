package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "actions")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Action {
  @Id
  private String code;
  private String name;
  private Integer fee;
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private ActionCategory category;
  @OneToMany(mappedBy = "action")
  private List<OutpatientAction> outpatientActions;
}
