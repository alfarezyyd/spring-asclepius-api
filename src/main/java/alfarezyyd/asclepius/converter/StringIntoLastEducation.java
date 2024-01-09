package alfarezyyd.asclepius.converter;


import alfarezyyd.asclepius.model.option.LastEducation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringIntoLastEducation implements Converter<String, LastEducation> {
  @Override
  public LastEducation convert(@NonNull String source) {
    return LastEducation.valueOf(source);
  }
}
