package alfarezyyd.asclepius.constraint;


import alfarezyyd.asclepius.validator.EthnicityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EthnicityValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EthnicityEnumConstraint {
    String message() default "invalid ethnicity";
  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
