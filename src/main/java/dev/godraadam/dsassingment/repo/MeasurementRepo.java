package dev.godraadam.dsassingment.repo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.dsassingment.model.Measurement;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Long> {

    List<Measurement> findAllBySensorIdAndTimestampBetween(Long sensorId, LocalDateTime from, LocalDateTime to);
}
