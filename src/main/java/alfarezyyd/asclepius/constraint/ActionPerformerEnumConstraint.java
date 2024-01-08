package alfarezyyd.asclepius.constraint;

import alfarezyyd.asclepius.validator.ActionPerformerEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ActionPerformerEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionPerformerEnumConstraint {
  String message() default "invalid action performer type";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
