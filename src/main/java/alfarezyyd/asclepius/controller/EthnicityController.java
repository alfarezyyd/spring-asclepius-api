package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityCreateRequest;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityResponse;
import alfarezyyd.asclepius.model.dto.ethnicity.EthnicityUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.EthnicityUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ethnicities")
public class EthnicityController {
  private final EthnicityUsecase ethnicityUsecase;

  public EthnicityController(EthnicityUsecase ethnicityUsecase) {
    this.ethnicityUsecase = ethnicityUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<EthnicityResponse>> findAll() {
    List<EthnicityResponse> allEthnicityResponse = ethnicityUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allEthnicityResponse);
  }

  @GetMapping(path = "/{ethnicityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<EthnicityResponse> findById(@PathVariable(name = "ethnicityId") Short ethnicityId) {
    EthnicityResponse ethnicityDetail = ethnicityUsecase.findById(ethnicityId);
    return ResponseWriter.writeIntoSuccessResponseBody(ethnicityDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody EthnicityCreateRequest ethnicityCreateRequest) {
    ethnicityUsecase.create(ethnicityCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(path = {"/{ethnicityId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@PathVariable Short ethnicityId, @RequestBody EthnicityUpdateRequest ethnicityUpdateRequest) {
    ethnicityUpdateRequest.setId(ethnicityId);
    ethnicityUsecase.update(ethnicityUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{ethnicityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "ethnicityId") Short ethnicityId) {
    ethnicityUsecase.delete(ethnicityId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

}
