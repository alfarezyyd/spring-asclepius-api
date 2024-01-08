package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.EthnicityEnumConstraint;
import alfarezyyd.asclepius.model.option.ActionPerformer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ActionPerformerEnumValidator implements ConstraintValidator<EthnicityEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }
    try {
      ActionPerformer.valueOf(value);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
