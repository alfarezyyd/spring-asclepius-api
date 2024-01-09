package alfarezyyd.asclepius.converter;


import alfarezyyd.asclepius.model.option.IdentityCardType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringIntoIdentityCardType implements Converter<String, IdentityCardType> {
  @Override
  public IdentityCardType convert(@NonNull String source) {
    return IdentityCardType.valueOf(source);
  }
}
