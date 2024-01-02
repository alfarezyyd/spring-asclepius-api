package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.LastEducationEnumConstraint;
import alfarezyyd.asclepius.model.option.LastEducation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LastEducationEnumValidator implements ConstraintValidator<LastEducationEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }
    try {
      LastEducation.valueOf(value);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
