package dev.godraadam.dsassingment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.dsassingment.model.Sensor;

@Repository
public interface SensorRepo extends JpaRepository<Sensor, Long> {

    @SuppressWarnings("checkstyle:MethodName")
    List<Sensor> findAllByMonitoredDevice_Owner_Id(Long userId);
}
