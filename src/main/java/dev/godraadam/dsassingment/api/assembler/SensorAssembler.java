package dev.godraadam.dsassingment.api.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.api.dto.SensorDTO;
import dev.godraadam.dsassingment.model.Sensor;

@Component
public class SensorAssembler implements GeneralAssembler<Sensor, SensorDTO> {

    @Autowired
    private MeasurementAssembler measurementAssembler;

    @Override
    public Sensor createModel(SensorDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setDescription(dto.getDescription());
        sensor.setMeasurements(measurementAssembler.createModelList(dto.getMeasurements()));
        return sensor;
    }

    @Override
    public SensorDTO createDTO(Sensor model) {
        SensorDTO dto = new SensorDTO();
        dto.setDescription(model.getDescription());
        dto.setDeviceId(model.getMonitoredDevice().getId());
        dto.setMaxValue(model.getMaxValue());
        dto.setSensorId(model.getId());
        dto.setMeasurements(measurementAssembler.createDTOList(model.getMeasurements()));
        return dto;
    }
}
