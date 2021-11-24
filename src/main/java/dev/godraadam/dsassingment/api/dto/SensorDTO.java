package dev.godraadam.dsassingment.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDTO {

    private Long sensorId;
    private Long deviceId;
    private String description;
    private Double maxValue;
    private List<MeasurementDTO> measurements;
}
