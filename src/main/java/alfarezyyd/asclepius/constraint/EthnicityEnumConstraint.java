package alfarezyyd.asclepius.constraint;


import alfarezyyd.asclepius.validator.EthnicityEnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EthnicityEnumValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EthnicityEnumConstraint {
    String message() default "invalid ethnicity";
  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
