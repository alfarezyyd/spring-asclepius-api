package alfarezyyd.asclepius.converter;

import alfarezyyd.asclepius.model.option.Religion;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

public class StringIntoConsciousnessEnum implements Converter<String, Religion> {
  @Override
  public Religion convert(@NonNull String source) {
    return Religion.valueOf(source);
  }
}
