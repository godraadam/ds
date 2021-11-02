package dev.godraadam.dsassingment.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDTO {
    private Long userId;
    private String description;
    private Double maxConsumption;
    private Double avgConsumption;
    private String address;
    private Long sensorId;
}
