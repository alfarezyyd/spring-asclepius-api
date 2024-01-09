package alfarezyyd.asclepius.model.dto.disease.category;

import alfarezyyd.asclepius.model.entity.Disease;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiseaseCategoryResponse {
  private Integer id;
  private String name;
  private List<Disease> diseases;
}
