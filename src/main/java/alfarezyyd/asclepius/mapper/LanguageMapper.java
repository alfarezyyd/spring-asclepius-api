package alfarezyyd.asclepius.mapper;

import alfarezyyd.asclepius.model.dto.language.LanguageDto;
import alfarezyyd.asclepius.model.dto.language.LanguageResponse;
import alfarezyyd.asclepius.model.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = PersonMapper.class)
public interface LanguageMapper {
  @Mapping(target = "patients", ignore = true)
  LanguageResponse languageEntityIntoLanguageResponse(Language languageEntity);
  LanguageResponse languageEntityIntoDetailLanguageResponse(Language languageEntity);
  void languageDtoIntoLanguageEntity(@MappingTarget Language languageEntity, LanguageDto languageDto);
}
