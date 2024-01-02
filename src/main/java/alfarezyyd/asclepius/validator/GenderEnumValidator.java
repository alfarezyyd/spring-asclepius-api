package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.GenderEnumConstraint;
import alfarezyyd.asclepius.model.option.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderEnumValidator implements ConstraintValidator<GenderEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }
    try {
      Gender.valueOf(value);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
