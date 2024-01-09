package alfarezyyd.asclepius.converter;


import alfarezyyd.asclepius.model.option.BloodType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringIntoBloodType implements Converter<String, BloodType> {
  @Override
  public BloodType convert(@NonNull String source) {
    return BloodType.valueOf(source);
  }
}
