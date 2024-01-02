package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.custodian.CustodianCreateRequest;
import alfarezyyd.asclepius.model.dto.custodian.CustodianResponse;
import alfarezyyd.asclepius.model.dto.custodian.CustodianUpdateRequest;

import java.util.List;

public interface CustodianUsecase {
  List<CustodianResponse> findAll();

  CustodianResponse findById(Long personId);

  void create(CustodianCreateRequest custodianCreateRequest);

  void update(CustodianUpdateRequest custodianUpdateRequest);

  void delete(Long personId);
}
