package alfarezyyd.asclepius.converter;


import alfarezyyd.asclepius.model.option.EthnicityType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringIntoEthnicityType implements Converter<String, EthnicityType> {
  @Override
  public EthnicityType convert(@NonNull String source) {
    return EthnicityType.valueOf(source);
  }
}
