package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.outpatient.OutpatientCreateRequest;
import alfarezyyd.asclepius.model.dto.outpatient.OutpatientResponse;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.OutpatientUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outpatients")
public class OutpatientController {
  private final OutpatientUsecase outpatientUsecase;

  public OutpatientController(OutpatientUsecase outpatientUsecase) {
    this.outpatientUsecase = outpatientUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<OutpatientResponse>> findAll() {
    List<OutpatientResponse> allOutpatientResponse = outpatientUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allOutpatientResponse);
  }

  @GetMapping(path = "/{outpatientId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<OutpatientResponse> findById(@PathVariable(name = "outpatientId") String outpatientId) {
    OutpatientResponse outpatientDetail = outpatientUsecase.findById(outpatientId);
    return ResponseWriter.writeIntoSuccessResponseBody(outpatientDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody OutpatientCreateRequest outpatientCreateRequest) {
    outpatientUsecase.create(outpatientCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{outpatientId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "outpatientId") String outpatientId) {
    outpatientUsecase.delete(outpatientId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

}
