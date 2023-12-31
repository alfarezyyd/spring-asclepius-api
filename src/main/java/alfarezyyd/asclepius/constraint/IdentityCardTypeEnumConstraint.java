package alfarezyyd.asclepius.constraint;

import alfarezyyd.asclepius.validator.IdentityCardTypeEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {IdentityCardTypeEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdentityCardTypeEnumConstraint {
  String message() default "invalid identity card type";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
