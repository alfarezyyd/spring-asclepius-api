package alfarezyyd.asclepius.usecase.impl;

import alfarezyyd.asclepius.mapper.PositionMapper;
import alfarezyyd.asclepius.model.dto.position.PositionCreateRequest;
import alfarezyyd.asclepius.model.dto.position.PositionResponse;
import alfarezyyd.asclepius.model.dto.position.PositionUpdateRequest;
import alfarezyyd.asclepius.model.entity.Position;
import alfarezyyd.asclepius.repository.PositionRepository;
import alfarezyyd.asclepius.usecase.PositionUsecase;
import alfarezyyd.asclepius.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PositionUsecaseImpl implements PositionUsecase {
  private final PositionRepository positionRepository;
  private final ValidationUtil validationUtil;
  private final PositionMapper positionMapper;

  public PositionUsecaseImpl(PositionRepository positionRepository, ValidationUtil validationUtil, PositionMapper positionMapper) {
    this.positionRepository = positionRepository;
    this.validationUtil = validationUtil;
    this.positionMapper = positionMapper;
  }

  @Override
  public List<PositionResponse> findAll() {
    return positionRepository.findAll().stream().map(positionMapper::positionEntityIntoPositionResponse).toList();
  }

  @Override
  public PositionResponse findById(String positionCode) {
    Position position = positionRepository.findById(positionCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "position not found"));
    return positionMapper.positionEntityIntoDetailPositionResponse(position);
  }

  @Override
  public void create(PositionCreateRequest positionCreateRequest) {
    validationUtil.validateRequest(positionCreateRequest);
    Position position = new Position();
    positionMapper.positionDtoIntoPositionEntity(position, positionCreateRequest);
    positionRepository.save(position);
  }

  @Override
  public void update(PositionUpdateRequest positionUpdateRequest) {
    validationUtil.validateRequest(positionUpdateRequest);
    Position position = positionRepository.findById(positionUpdateRequest.getCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "position not found"));
    positionMapper.positionDtoIntoPositionEntity(position, positionUpdateRequest);
    positionRepository.save(position);
  }

  @Override
  public void delete(String positionCode) {
    if (positionRepository.existsById(positionCode)) {
      positionRepository.deleteById(positionCode);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "position not found");
    }
  }
}
