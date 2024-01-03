package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.instance.InstanceCreateRequest;
import alfarezyyd.asclepius.model.dto.instance.InstanceResponse;
import alfarezyyd.asclepius.model.dto.instance.InstanceUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.InstanceUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instances")
public class InstanceController {
  private final InstanceUsecase instanceUsecase;

  public InstanceController(InstanceUsecase instanceUsecase) {
    this.instanceUsecase = instanceUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<InstanceResponse>> findAll() {
    List<InstanceResponse> allInstanceResponse = instanceUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allInstanceResponse);
  }

  @GetMapping(path = "/{instanceCode}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<InstanceResponse> findById(@PathVariable(name = "instanceCode") String instanceCode) {
    InstanceResponse instanceDetail = instanceUsecase.findById(instanceCode);
    return ResponseWriter.writeIntoSuccessResponseBody(instanceDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody InstanceCreateRequest instanceCreateRequest) {
    instanceUsecase.create(instanceCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(path = {"/{instanceCode}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@PathVariable String instanceCode, @RequestBody InstanceUpdateRequest instanceUpdateRequest) {
    instanceUpdateRequest.setCode(instanceCode);
    instanceUsecase.update(instanceUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{instanceCode}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "instanceCode") String instanceCode) {
    instanceUsecase.delete(instanceCode);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

}
