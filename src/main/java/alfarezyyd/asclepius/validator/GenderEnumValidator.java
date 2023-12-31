package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.GenderEnumConstraint;
import alfarezyyd.asclepius.model.option.IdentityCardType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderEnumValidator implements ConstraintValidator<GenderEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }

    return IdentityCardType.fromValue(value) != null;
  }
}
