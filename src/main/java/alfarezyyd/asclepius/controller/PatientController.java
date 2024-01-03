package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.patient.PatientCreateRequest;
import alfarezyyd.asclepius.model.dto.patient.PatientResponse;
import alfarezyyd.asclepius.model.dto.patient.PatientUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.PatientUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
  private final PatientUsecase patientUsecase;

  public PatientController(PatientUsecase patientUsecase) {
    this.patientUsecase = patientUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<PatientResponse>> findAll() {
    List<PatientResponse> allPatientResponse = patientUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allPatientResponse);
  }

  @GetMapping(path = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<PatientResponse> findById(@PathVariable(name = "personId") Long personId) {
    PatientResponse patientDetail = patientUsecase.findById(personId);
    return ResponseWriter.writeIntoSuccessResponseBody(patientDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody PatientCreateRequest patientCreateRequest) {
    patientUsecase.create(patientCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(path = {"/{personId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@PathVariable Long personId, @RequestBody PatientUpdateRequest patientUpdateRequest) {
    patientUpdateRequest.setPersonId(personId);
    patientUsecase.update(patientUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{peopledId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "peopledId") Long personId) {
    patientUsecase.delete(personId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }
}
