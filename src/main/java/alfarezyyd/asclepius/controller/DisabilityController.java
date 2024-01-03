package alfarezyyd.asclepius.controller;


import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.disability.DisabilityCreateRequest;
import alfarezyyd.asclepius.model.dto.disability.DisabilityResponse;
import alfarezyyd.asclepius.model.dto.disability.DisabilityUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.DisabilityUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disabilities")
public class DisabilityController {
  private final DisabilityUsecase disabilityUsecase;

  public DisabilityController(DisabilityUsecase disabilityUsecase) {
    this.disabilityUsecase = disabilityUsecase;
  }

   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<DisabilityResponse>> findAll() {
    List<DisabilityResponse> allDisabilityResponse = disabilityUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allDisabilityResponse);
  }

  @GetMapping(path = "/{disabilityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<DisabilityResponse> findById(@PathVariable(name = "disabilityId") Short disabilityId) {
    DisabilityResponse disabilityDetail = disabilityUsecase.findById(disabilityId);
    return ResponseWriter.writeIntoSuccessResponseBody(disabilityDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody DisabilityCreateRequest disabilityCreateRequest) {
    disabilityUsecase.create(disabilityCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(path = {"/{disabilityId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@PathVariable Short disabilityId, @RequestBody DisabilityUpdateRequest disabilityUpdateRequest) {
    disabilityUpdateRequest.setId(disabilityId);
    disabilityUsecase.update(disabilityUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{disabilityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "disabilityId") Short disabilityId) {
    disabilityUsecase.delete(disabilityId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

}
