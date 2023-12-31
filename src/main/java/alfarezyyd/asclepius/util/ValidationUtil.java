package alfarezyyd.asclepius.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidationUtil {
  private final Validator validator;

  public ValidationUtil(Validator validator) {
    this.validator = validator;
  }

  public void validateRequest(Object varRequest){
    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(varRequest);
    if (!constraintViolations.isEmpty()){
      throw new ConstraintViolationException(constraintViolations);
    }
  }
}
