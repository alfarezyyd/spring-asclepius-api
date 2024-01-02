package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.BloodTypeEnumConstraint;
import alfarezyyd.asclepius.model.option.BloodType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BloodTypeEnumValidator implements ConstraintValidator<BloodTypeEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }

    try {
      BloodType.valueOf(value);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
