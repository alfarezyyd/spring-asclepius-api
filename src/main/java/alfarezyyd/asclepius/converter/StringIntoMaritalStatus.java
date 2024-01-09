package alfarezyyd.asclepius.converter;


import alfarezyyd.asclepius.model.option.MaritalStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringIntoMaritalStatus implements Converter<String, MaritalStatus> {
  @Override
  public MaritalStatus convert(@NonNull String source) {
    return MaritalStatus.valueOf(source);
  }
}
