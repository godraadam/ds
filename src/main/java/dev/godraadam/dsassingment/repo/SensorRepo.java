package dev.godraadam.dsassingment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.dsassingment.model.Sensor;

@Repository
public interface SensorRepo extends JpaRepository<Sensor, Long> {

}
