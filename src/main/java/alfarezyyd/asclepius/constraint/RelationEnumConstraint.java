package alfarezyyd.asclepius.constraint;

import alfarezyyd.asclepius.validator.RelationEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {RelationEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RelationEnumConstraint {
  String message() default "invalid relation";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
