package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.instance.InstanceCreateRequest;
import alfarezyyd.asclepius.model.dto.instance.InstanceResponse;
import alfarezyyd.asclepius.model.dto.instance.InstanceUpdateRequest;

import java.util.List;

public interface InstanceUsecase {
  List<InstanceResponse> findAll();

  InstanceResponse findById(String instanceCode);

  void create(InstanceCreateRequest instanceCreateRequest);

  void update(InstanceUpdateRequest instanceUpdateRequest);

  void delete(String instanceCode);
}
