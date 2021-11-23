package dev.godraadam.dsassingment.api.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.api.dto.MeasurementDTO;
import dev.godraadam.dsassingment.model.Measurement;
import dev.godraadam.dsassingment.service.SensorService;

@Component
public class MeasurementAssembler implements GeneralAssembler<Measurement, MeasurementDTO> {

    @Autowired
    private SensorService sensorService;

    @Override
    public Measurement createModel(MeasurementDTO dto) {
        Measurement model = new Measurement();
        model.setTimestamp(dto.getTimestamp());
        model.setValue(model.getValue());
        model.setSensor(sensorService.getSensorById(dto.getId()));
        return model;
    }

    @Override
    public MeasurementDTO createDTO(Measurement model) {
        MeasurementDTO dto = new MeasurementDTO();
        dto.setSensorId(model.getSensor().getId());
        dto.setTimestamp(model.getTimestamp());
        dto.setValue(model.getValue());
        dto.setId(model.getId());
        return dto;
    }
}
