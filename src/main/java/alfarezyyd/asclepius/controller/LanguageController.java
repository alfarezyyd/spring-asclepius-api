package alfarezyyd.asclepius.controller;


import alfarezyyd.asclepius.helper.ResponseWriter;
import alfarezyyd.asclepius.model.dto.language.LanguageCreateRequest;
import alfarezyyd.asclepius.model.dto.language.LanguageResponse;
import alfarezyyd.asclepius.model.dto.language.LanguageUpdateRequest;
import alfarezyyd.asclepius.model.web.WebResponse;
import alfarezyyd.asclepius.usecase.LanguageUsecase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {
  private final LanguageUsecase languageUsecase;

  public LanguageController(LanguageUsecase languageUsecase) {
    this.languageUsecase = languageUsecase;
  }

   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<List<LanguageResponse>> findAll() {
    List<LanguageResponse> allLanguageResponse = languageUsecase.findAll();
    return ResponseWriter.writeIntoSuccessResponseBody(allLanguageResponse);
  }

  @GetMapping(path = "/{languageId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<LanguageResponse> findById(@PathVariable(name = "languageId") Short languageId) {
    LanguageResponse languageDetail = languageUsecase.findById(languageId);
    return ResponseWriter.writeIntoSuccessResponseBody(languageDetail);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> create(@RequestBody LanguageCreateRequest languageCreateRequest) {
    languageUsecase.create(languageCreateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @PutMapping(path = {"/{languageId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> update(@PathVariable Short languageId, @RequestBody LanguageUpdateRequest languageUpdateRequest) {
    languageUpdateRequest.setId(languageId);
    languageUsecase.update(languageUpdateRequest);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }

  @DeleteMapping(path = "/{languageId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WebResponse<String> delete(@PathVariable(name = "languageId") Short languageId) {
    languageUsecase.delete(languageId);
    return ResponseWriter.writeIntoSuccessResponseBody("Success");
  }
}
