package dev.godraadam.dsassingment.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sensor extends BaseModel {
    @OneToOne(mappedBy = "sensor")
    private Device monitoredDevice;
    private String description;
    private Double maxValue;

    //list of measurement records (one every hour)
    @OneToMany(mappedBy = "sensor")
    private List<Measurement> measurements;
}
