package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicCreateRequest;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicResponse;
import alfarezyyd.asclepius.model.dto.polyclinic.PolyclinicUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.PolyclinicUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/polyclinics")
public class PolyclinicController {
  private final PolyclinicUsecase polyclinicUsecase;

  public PolyclinicController(PolyclinicUsecase polyclinicUsecase) {
    this.polyclinicUsecase = polyclinicUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<PolyclinicResponse>> findAll() {
    List<PolyclinicResponse> allPolyclinicResponse = polyclinicUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allPolyclinicResponse);
  }

  @GetMapping(path = "/{polyclinicId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<PolyclinicResponse> findById(@PathVariable(name = "polyclinicId") String polyclinicId) {
    PolyclinicResponse polyclinicDetail = polyclinicUsecase.findById(polyclinicId);
    return ResponseWriter.writeIntoSuccessResponseBody(polyclinicDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody PolyclinicCreateRequest polyclinicCreateRequest) {
    polyclinicUsecase.create(polyclinicCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@RequestBody PolyclinicUpdateRequest polyclinicUpdateRequest) {
    polyclinicUsecase.update(polyclinicUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{polyclinicId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "polyclinicId") String polyclinicId) {
    polyclinicUsecase.delete(polyclinicId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

}
