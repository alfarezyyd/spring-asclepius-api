package alfarezyyd.asclepius.converter;


import alfarezyyd.asclepius.model.option.Gender;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringIntoGender implements Converter<String, Gender> {
  @Override
  public Gender convert(@NonNull String source) {
    return Gender.valueOf(source);
  }
}
