package dev.godraadam.dsassingment.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Device extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser owner;
    private String description;
    private Double maxConsumption;
    private Double avgConsumption;
    private String address;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "sensor_id")
    @Nullable
    private Sensor sensor;
}
