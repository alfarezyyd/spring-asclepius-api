package alfarezyyd.asclepius.validator;

import alfarezyyd.asclepius.constraint.RelationEnumConstraint;
import alfarezyyd.asclepius.model.option.Relation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RelationEnumValidator implements ConstraintValidator<RelationEnumConstraint, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // skip validation if null
    if (value == null) {
      return true;
    }
    try {
      Relation.valueOf(value);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}
