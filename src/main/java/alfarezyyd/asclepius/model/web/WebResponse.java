package alfarezyyd.asclepius.model.web;

import lombok.Builder;

@Builder
public class WebResponse<T> {
  private T responseData;
  private String errorMessage;
}
