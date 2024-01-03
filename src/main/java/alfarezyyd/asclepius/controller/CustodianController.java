package alfarezyyd.asclepius.controller;

import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.custodian.CustodianCreateRequest;
import alfarezyyd.asclepius.model.dto.custodian.CustodianResponse;
import alfarezyyd.asclepius.model.dto.custodian.CustodianUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.CustodianUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/custodians")
public class CustodianController {
  private final CustodianUsecase custodianUsecase;

  public CustodianController(CustodianUsecase custodianUsecase) {
    this.custodianUsecase = custodianUsecase;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<CustodianResponse>> findAll() {
    List<CustodianResponse> allCustodianResponse = custodianUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allCustodianResponse);
  }

  @GetMapping(path = "/{custodianId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<CustodianResponse> findById(@PathVariable(name = "custodianId") Long custodianId) {
    CustodianResponse custodianDetail = custodianUsecase.findById(custodianId);
    return ResponseWriter.writeIntoSuccessResponseBody(custodianDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody CustodianCreateRequest custodianCreateRequest) {
    custodianUsecase.create(custodianCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(path = {"/{custodianId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@PathVariable Long custodianId, @RequestBody CustodianUpdateRequest custodianUpdateRequest) {
    custodianUpdateRequest.setPersonId(custodianId);
    custodianUsecase.update(custodianUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{custodianId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "custodianId") Long custodianId) {
    custodianUsecase.delete(custodianId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

}
