package dev.godraadam.dsassingment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.dsassingment.model.Device;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Long> {

}
