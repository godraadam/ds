package dev.godraadam.dsassingment.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import dev.godraadam.dsassingment.model.BaseModel;

public interface GeneralAssembler<M extends BaseModel, D> {

    M createModel(D dto);

    D createDTO(M model);

    default List<M> createModelList(List<D> dtos) {
        return dtos.stream().map(dto -> createModel(dto)).collect(Collectors.toList());
    }

    default List<D> createDTOList(List<M> models) {
        return models.stream().map(m -> createDTO(m)).collect(Collectors.toList());
    }
}
