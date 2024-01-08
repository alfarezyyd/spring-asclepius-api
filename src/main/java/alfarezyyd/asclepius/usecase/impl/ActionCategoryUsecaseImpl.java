package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.ActionCategoryMapper;
import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryCreateRequest;
import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryResponse;
import alfarezyyd.asclepius.model.dto.action.category.ActionCategoryUpdateRequest;
import alfarezyyd.asclepius.model.entity.ActionCategory;
import alfarezyyd.asclepius.repository.ActionCategoryRepository;
import alfarezyyd.asclepius.usecase.ActionCategoryUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActionCategoryUsecaseImpl implements ActionCategoryUsecase {
  private final ActionCategoryRepository actionCategoryRepository;
  private final ActionCategoryMapper actionCategoryMapper;
  private final ValidationUtil validationUtil;

  public ActionCategoryUsecaseImpl(ActionCategoryRepository actionCategoryRepository, ActionCategoryMapper actionCategoryMapper, ValidationUtil validationUtil) {
    this.actionCategoryRepository = actionCategoryRepository;
    this.actionCategoryMapper = actionCategoryMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<ActionCategoryResponse> findAll() {
    return actionCategoryRepository.findAll().stream().map(actionCategoryMapper::actionCategoryEntityIntoActionCategoryResponse).toList();
  }

  @Override
  public ActionCategoryResponse findById(Integer actionCategoryId) {
    ActionCategory actionCategory = actionCategoryRepository.findById(actionCategoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "actionCategory not found"));
    return actionCategoryMapper.actionCategoryEntityIntoDetailActionCategoryResponse(actionCategory);
  }

  @Override
  public void create(ActionCategoryCreateRequest actionCategoryCreateRequest) {
    validationUtil.validateRequest(actionCategoryCreateRequest);
    ActionCategory newActionCategory = new ActionCategory();
    actionCategoryMapper.actionCategoryDtoIntoActionCategoryEntity(newActionCategory, actionCategoryCreateRequest);
    actionCategoryRepository.save(newActionCategory);
  }

  @Override
  public void update(ActionCategoryUpdateRequest actionCategoryUpdateRequest) {
    validationUtil.validateRequest(actionCategoryUpdateRequest);
    ActionCategory actionCategory = actionCategoryRepository.findById(actionCategoryUpdateRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "actionCategory not found"));
    actionCategoryMapper.actionCategoryDtoIntoActionCategoryEntity(actionCategory, actionCategoryUpdateRequest);
    actionCategoryRepository.save(actionCategory);
  }

  @Override
  public void delete(Integer actionCategoryId) {
    if (actionCategoryRepository.existsById(actionCategoryId)) {
      actionCategoryRepository.deleteById(actionCategoryId);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "actionCategory not found");
    }
  }
}
