package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.ReligionEnumConstraint;
import alfarezyyd.asclepius.model.option.Religion;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ReligionEnumValidator implements ConstraintValidator<ReligionEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }

    return Religion.fromValue(value) != null;
  }
}
