package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.ActionMapper;
import alfarezyyd.asclepius.model.dto.action.ActionCreateRequest;
import alfarezyyd.asclepius.model.dto.action.ActionResponse;
import alfarezyyd.asclepius.model.dto.action.ActionUpdateRequest;
import alfarezyyd.asclepius.model.entity.Action;
import alfarezyyd.asclepius.model.entity.ActionCategory;
import alfarezyyd.asclepius.repository.ActionCategoryRepository;
import alfarezyyd.asclepius.repository.ActionRepository;
import alfarezyyd.asclepius.usecase.ActionUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActionUsecaseImpl implements ActionUsecase {
  private final ActionRepository actionRepository;
  private final ActionCategoryRepository actionCategoryRepository;
  private final ActionMapper actionMapper;
  private final ValidationUtil validationUtil;

  public ActionUsecaseImpl(ActionRepository actionRepository, ActionCategoryRepository actionCategoryRepository, ActionMapper actionMapper, ValidationUtil validationUtil) {
    this.actionRepository = actionRepository;
    this.actionCategoryRepository = actionCategoryRepository;
    this.actionMapper = actionMapper;
    this.validationUtil = validationUtil;
  }

  @Override
  public List<ActionResponse> findAll() {
    return actionRepository.findAll().stream().map(actionMapper::actionEntityIntoActionResponse).toList();
  }

  @Override
  public ActionResponse findById(String actionCode) {
    Action action = actionRepository.findById(actionCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "action not found"));
    return actionMapper.actionEntityIntoDetailActionResponse(action);
  }

  @Override
  public void create(ActionCreateRequest actionCreateRequest) {
    validationUtil.validateRequest(actionCreateRequest);
    Action newAction = new Action();
    actionMapper.actionDtoIntoActionEntity(newAction, actionCreateRequest);
    ActionCategory actionCategory = actionCategoryRepository.findById(actionCreateRequest.getCategory()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "action category not found"));
    newAction.setCategory(actionCategory);
    actionRepository.save(newAction);
  }

  @Override
  public void update(ActionUpdateRequest actionUpdateRequest) {
    validationUtil.validateRequest(actionUpdateRequest);
    Action action = actionRepository.findById(actionUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "action not found"));
    actionMapper.actionDtoIntoActionEntity(action, actionUpdateRequest);
    if (!action.getCategory().getId().equals(actionUpdateRequest.getCategory())) {
      ActionCategory actionCategory = actionCategoryRepository.findById(actionUpdateRequest.getCategory()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "action category not found"));
      action.setCategory(actionCategory);
      action.setCategory(actionCategory);
    }
    actionRepository.save(action);
  }

  @Override
  public void delete(String actionCode) {
    if (actionRepository.existsById(actionCode)) {
      actionRepository.deleteById(actionCode);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "action not found");
    }
  }
}
