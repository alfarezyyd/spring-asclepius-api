package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.doctor.DoctorCreateRequest;
import alfarezyyd.asclepius.model.dto.doctor.DoctorResponse;
import alfarezyyd.asclepius.model.dto.doctor.DoctorUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.DoctorUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
  private final DoctorUsecase doctorUsecase;

  public DoctorController(DoctorUsecase doctorUsecase) {
    this.doctorUsecase = doctorUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<DoctorResponse>> findAll() {
    List<DoctorResponse> allDoctorResponse = doctorUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allDoctorResponse);
  }

  @GetMapping(path = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<DoctorResponse> findById(@PathVariable(name = "personId") Long personId) {
    DoctorResponse doctorDetail = doctorUsecase.findById(personId);
    return ResponseWriter.writeIntoSuccessResponseBody(doctorDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody DoctorCreateRequest doctorCreateRequest) {
    doctorUsecase.create(doctorCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(path = {"/{personId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@PathVariable Long personId, @RequestBody DoctorUpdateRequest doctorUpdateRequest) {
    doctorUpdateRequest.setPersonId(personId);
    doctorUsecase.update(doctorUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{peopledId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "peopledId") Long personId) {
    doctorUsecase.delete(personId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }
}
