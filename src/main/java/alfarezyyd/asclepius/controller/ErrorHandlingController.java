package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.model.web.WebResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ErrorHandlingController {
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<WebResponse<String>> constraintViolationException(ConstraintViolationException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(WebResponse.<String>builder()
            .responseData(null)
            .errorMessage(exception.getMessage())
            .build());
  }

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<WebResponse<String>> responseStatusException(ResponseStatusException exception){
    return ResponseEntity.status(exception.getStatusCode())
        .body(WebResponse.<String>builder()
            .responseData(null)
            .errorMessage(exception.getMessage())
            .build());
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<WebResponse<String>> illegalArgumentException(IllegalArgumentException exception){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(WebResponse.<String>builder()
            .responseData(null)
            .errorMessage(exception.getMessage())
            .build());
  }
}
