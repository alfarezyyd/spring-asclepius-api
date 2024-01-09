package alfarezyyd.asclepius.converter;


import alfarezyyd.asclepius.model.option.ActionPerformer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringIntoActionPerformer implements Converter<String, ActionPerformer> {
  @Override
  public ActionPerformer convert(@NonNull String source) {
    return ActionPerformer.valueOf(source);
  }
}
