package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceCreateRequest;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceResponse;
import alfarezyyd.asclepius.model.dto.insurance.InsuranceUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.InsuranceUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/insurances")
public class InsuranceController {
  private final InsuranceUsecase insuranceUsecase;

  public InsuranceController(InsuranceUsecase insuranceUsecase) {
    this.insuranceUsecase = insuranceUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<InsuranceResponse>> findAll() {
    List<InsuranceResponse> allInsuranceResponse = insuranceUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allInsuranceResponse);
  }

  @GetMapping(path = "/{insuranceCode}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<InsuranceResponse> findById(@PathVariable(name = "insuranceCode") String insuranceCode) {
    InsuranceResponse insuranceDetail = insuranceUsecase.findById(insuranceCode);
    return ResponseWriter.writeIntoSuccessResponseBody(insuranceDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody InsuranceCreateRequest insuranceCreateRequest) {
    insuranceUsecase.create(insuranceCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(path = {"/{insuranceCode}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@PathVariable String insuranceCode, @RequestBody InsuranceUpdateRequest insuranceUpdateRequest) {
    insuranceUpdateRequest.setCode(insuranceCode);
    insuranceUsecase.update(insuranceUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{insuranceCode}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "insuranceCode") String insuranceCode) {
    insuranceUsecase.delete(insuranceCode);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

}
