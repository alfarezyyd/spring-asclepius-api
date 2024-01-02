package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.LanguageMapper;
import alfarezyyd.asclepius.model.dto.language.LanguageCreateRequest;
import alfarezyyd.asclepius.model.dto.language.LanguageResponse;
import alfarezyyd.asclepius.model.dto.language.LanguageUpdateRequest;
import alfarezyyd.asclepius.model.entity.Language;
import alfarezyyd.asclepius.repository.LanguageRepository;
import alfarezyyd.asclepius.usecase.LanguageUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LanguageUsecaseImpl implements LanguageUsecase {
  private final LanguageRepository languageRepository;
  private final LanguageMapper languageMapper;
  private final ValidationUtil validationUtil;

  public LanguageUsecaseImpl(LanguageRepository languageRepository, LanguageMapper languageMapper, ValidationUtil validationUtil) {
    this.languageRepository = languageRepository;
    this.languageMapper = languageMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<LanguageResponse> findAll() {
    return languageRepository.findAll().stream().map(languageMapper::languageEntityIntoLanguageResponse).toList();
  }

  @Override
  public LanguageResponse findById(Long languageId) {
    Language language = languageRepository.findById(languageId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "language not found"));
    return languageMapper.languageEntityIntoDetailLanguageResponse(language);
  }

  @Override
  public void create(LanguageCreateRequest languageCreateRequest) {
    validationUtil.validateRequest(languageCreateRequest);
    Language newLanguage = new Language();
    languageMapper.languageDtoIntoLanguageEntity(newLanguage, languageCreateRequest);
    languageRepository.save(newLanguage);
  }

  @Override
  public void update(LanguageUpdateRequest languageUpdateRequest) {
    validationUtil.validateRequest(languageUpdateRequest);
    Language language = languageRepository.findById(languageUpdateRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "language not found"));
    languageMapper.languageDtoIntoLanguageEntity(language, languageUpdateRequest);
    languageRepository.save(language);
  }

  @Override
  public void delete(Long languageId) {
    if (languageRepository.existsById(languageId)) {
      languageRepository.deleteById(languageId);
    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "language not found");
    }
  }
}
