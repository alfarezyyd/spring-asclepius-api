package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityCreateRequest;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityResponse;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityUpdateRequest;

import java.util.List;

public interface EthnicityUsecase {
  List<EthnicityResponse> findAll();

  EthnicityResponse findById(Short ethnicityId);

  void create(EthnicityCreateRequest ethnicityCreateRequest);

  void update(EthnicityUpdateRequest ethnicityUpdateRequest);

  void delete(Short ethnicityId);
}
