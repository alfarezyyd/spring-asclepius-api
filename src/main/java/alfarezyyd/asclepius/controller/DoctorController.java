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

  @GetMapping(path = "/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<DoctorResponse> findById(@PathVariable(name = "doctorId") Long doctorId) {
    DoctorResponse doctorDetail = doctorUsecase.findById(doctorId);
    return ResponseWriter.writeIntoSuccessResponseBody(doctorDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody DoctorCreateRequest doctorCreateRequest) {
    doctorUsecase.create(doctorCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@RequestBody DoctorUpdateRequest doctorUpdateRequest) {
    doctorUsecase.update(doctorUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "doctorId") Long doctorId) {
    doctorUsecase.delete(doctorId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }
}
