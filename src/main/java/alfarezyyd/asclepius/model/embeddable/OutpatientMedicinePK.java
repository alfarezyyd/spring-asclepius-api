package alfarezyyd.asclepius.model.embeddable;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OutpatientMedicinePK implements Serializable {
  private String medicineCode;
  private String registrationCode;
}
