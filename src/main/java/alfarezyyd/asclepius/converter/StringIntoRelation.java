package alfarezyyd.asclepius.converter;


import alfarezyyd.asclepius.model.option.Relation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringIntoRelation implements Converter<String, Relation> {
  @Override
  public Relation convert(@NonNull String source) {
    return Relation.valueOf(source);
  }
}
