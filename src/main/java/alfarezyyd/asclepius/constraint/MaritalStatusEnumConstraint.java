package alfarezyyd.asclepius.constraint;

import alfarezyyd.asclepius.validator.MaritalStatusEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {MaritalStatusEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaritalStatusEnumConstraint {
  String message() default "invalid marital status";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
