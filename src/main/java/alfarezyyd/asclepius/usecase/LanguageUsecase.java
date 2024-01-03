package alfarezyyd.asclepius.usecase;

import alfarezyyd.asclepius.model.dto.language.LanguageCreateRequest;
import alfarezyyd.asclepius.model.dto.language.LanguageResponse;
import alfarezyyd.asclepius.model.dto.language.LanguageUpdateRequest;

import java.util.List;

public interface LanguageUsecase {
  List<LanguageResponse> findAll();

  LanguageResponse findById(Short languageId);

  void create(LanguageCreateRequest languageCreateRequest);

  void update(LanguageUpdateRequest languageUpdateRequest);

  void delete(Short languageId);
}
