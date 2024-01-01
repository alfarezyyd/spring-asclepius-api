package alfarezyyd.asclepius.helper;

import alfarezyyd.asclepius.model.web.WebResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponseWriter {
  private ResponseWriter() {
  }

  public static <T> WebResponse<T> writeIntoSuccessResponseBody(T responseData) {
     return WebResponse.<T>builder()
        .responseData(responseData)
        .errorMessage(null)
        .build();
  }
}
