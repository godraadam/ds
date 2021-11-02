package dev.godraadam.dsassingment.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Measurement extends BaseModel {
    private LocalDateTime timestamp;
    private Double value; //kWh, accumulative
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
}
