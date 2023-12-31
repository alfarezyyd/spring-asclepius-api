package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.IdentityCardTypeEnumConstraint;
import alfarezyyd.asclepius.model.option.IdentityCardType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentityCardTypeEnumValidator implements ConstraintValidator<IdentityCardTypeEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }

    return IdentityCardType.fromValue(value) != null;
  }
}
