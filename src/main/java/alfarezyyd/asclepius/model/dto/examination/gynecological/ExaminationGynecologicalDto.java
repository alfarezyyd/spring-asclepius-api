package alfarezyyd.asclepius.model.dto.examination.gynecological;

import alfarezyyd.asclepius.model.option.FluorAlbus;
import alfarezyyd.asclepius.model.option.Fluxus;
import alfarezyyd.asclepius.model.option.Mobility;
import alfarezyyd.asclepius.model.option.Tenderness;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public interface ExaminationGynecologicalDto {
  Long getExaminationId();

  String getInspection();

  String getVulva();

  String getInspeculo();

  Fluxus getFluxus();

  FluorAlbus getFluorAlbus();

  String getPortioInspeculo();

  String getSondageInspeculo();

  String getInternalPortioInspeculo();

  String getShape();

  String getUterineCavity();

  Mobility getMobility();

  String getSize();

  Tenderness getTenderness();

  String getRightAdnexa();

  String getLeftAdnexa();

  String getDouglasCavity();
}
