package alfarezyyd.asclepius.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "polyclinics")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Polyclinic {
  @Id
  private String code;
  private String name;
  @Column(name = "registration_fee")
  private Integer registrationFee;
  private String location;
  private String note;
  @ManyToMany(mappedBy = "polyclinics")
  private List<Doctor> polyclinics;

}
