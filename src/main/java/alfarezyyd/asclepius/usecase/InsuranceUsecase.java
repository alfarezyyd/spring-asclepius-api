package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.insurance.InsuranceCreateRequest;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceResponse;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceUpdateRequest;

import java.util.List;

public interface InsuranceUsecase {
  List<InsuranceResponse> findAll();

  InsuranceResponse findById(String insuranceCode);

  void create(InsuranceCreateRequest insuranceCreateRequest);

  void update(InsuranceUpdateRequest insuranceUpdateRequest);

  void delete(String insuranceCode);
}
