package alfarezyyd.asclepius.model.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pharmaceuticals_industries")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PharmaceuticalIndustry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String description;
  @OneToMany(mappedBy = "pharmaceuticalIndustry")
  private List<Medicine> medicines;
}
