package alfarezyyd.asclepius.constraint;

import alfarezyyd.asclepius.validator.ReligionEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ReligionEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReligionEnumConstraint {
  String message() default "invalid religion";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
