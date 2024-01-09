package alfarezyyd.asclepius.model.entity;

import alfarezyyd.asclepius.model.embeddable.OutpatientMedicinePK;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "outpatients_medicines")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class OutpatientMedicine {
  @EmbeddedId
  private OutpatientMedicinePK outpatientMedicinePK;
  @MapsId("medicineCode")
  @ManyToOne
  @JoinColumn(name = "medicine_code", referencedColumnName = "code")
  private Medicine medicines;
  @MapsId("registrationCode")
  @ManyToOne
  @JoinColumn(name = "registration_code", referencedColumnName = "registration_code")
  private Outpatient registrationCode;
}
