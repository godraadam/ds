package dev.godraadam.dsassingment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.dsassingment.model.Measurement;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Long> {
    
}
