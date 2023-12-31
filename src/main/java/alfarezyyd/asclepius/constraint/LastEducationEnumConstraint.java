package alfarezyyd.asclepius.constraint;

import alfarezyyd.asclepius.validator.LastEducationEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {LastEducationEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LastEducationEnumConstraint {
  String message() default "invalid last education option";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
