package dev.godraadam.dsassingment.api.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementDTO {
    private Long sensorId;
    private Double value;
    private LocalDateTime timestamp;
    private Long id;
}
