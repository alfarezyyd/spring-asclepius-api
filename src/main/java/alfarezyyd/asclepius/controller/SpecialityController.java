package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityCreateRequest;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityResponse;
import alfarezyyd.asclepius.model.dto.speciality.SpecialityUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.SpecialityUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/specialities")
public class SpecialityController {
  private final SpecialityUsecase specialityUsecase;

  public SpecialityController(SpecialityUsecase specialityUsecase) {
    this.specialityUsecase = specialityUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<SpecialityResponse>> findAll() {
    List<SpecialityResponse> allSpecialityResponse = specialityUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allSpecialityResponse);
  }

  @GetMapping(path = "/{specialityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<SpecialityResponse> findById(@PathVariable(name = "specialityId") String specialityId) {
    SpecialityResponse specialityDetail = specialityUsecase.findById(specialityId);
    return ResponseWriter.writeIntoSuccessResponseBody(specialityDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody SpecialityCreateRequest specialityCreateRequest) {
    specialityUsecase.create(specialityCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@RequestBody SpecialityUpdateRequest specialityUpdateRequest) {
    specialityUsecase.update(specialityUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{specialityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "specialityId") String specialityId) {
    specialityUsecase.delete(specialityId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }
}
