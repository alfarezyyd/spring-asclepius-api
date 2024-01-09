package alfarezyyd.asclepius.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class StringIntoDate implements Converter<String, Date> {
  @Override
  public Date convert(@NonNull String source) {
    return Date.valueOf(source);
  }
}
