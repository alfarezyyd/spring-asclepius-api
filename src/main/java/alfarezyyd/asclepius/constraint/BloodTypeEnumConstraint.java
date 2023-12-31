package alfarezyyd.asclepius.constraint;

import alfarezyyd.asclepius.validator.BloodTypeEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {BloodTypeEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BloodTypeEnumConstraint {
  String message() default "invalid blood type";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
