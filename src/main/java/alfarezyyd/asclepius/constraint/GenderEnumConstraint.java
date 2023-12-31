package alfarezyyd.asclepius.constraint;

import alfarezyyd.asclepius.validator.GenderEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {GenderEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenderEnumConstraint {
  String message() default "invalid gender";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
