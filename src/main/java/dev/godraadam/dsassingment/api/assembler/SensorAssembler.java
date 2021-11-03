package dev.godraadam.dsassingment.api.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.api.dto.SensorDTO;
import dev.godraadam.dsassingment.model.Sensor;

@Component
public class SensorAssembler implements GeneralAssembler<Sensor, SensorDTO> {

    @Override
    public Sensor createModel(SensorDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setDescription(dto.getDescription());
        return sensor;
    }

    @Override
    public SensorDTO createDTO(Sensor model) {
        SensorDTO dto = new SensorDTO();
        dto.setDescription(model.getDescription());
        dto.setDeviceId(model.getMonitoredDevice().getId());
        dto.setMaxValue(model.getMaxValue());
        dto.setSensorId(model.getId());
        dto.setMeasurements(model.getMeasurements());
        return dto;
    }
}
