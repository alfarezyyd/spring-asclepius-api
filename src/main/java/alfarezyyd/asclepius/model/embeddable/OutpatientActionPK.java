package alfarezyyd.asclepius.model.embeddable;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class OutpatientActionPK implements Serializable {
  private String actionCode;
  private String registrationCode;
}
