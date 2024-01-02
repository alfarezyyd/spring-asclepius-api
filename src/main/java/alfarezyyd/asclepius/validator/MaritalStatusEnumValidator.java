package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.MaritalStatusEnumConstraint;
import alfarezyyd.asclepius.model.option.MaritalStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MaritalStatusEnumValidator implements ConstraintValidator<MaritalStatusEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }

    try {
      MaritalStatus.valueOf(value);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
