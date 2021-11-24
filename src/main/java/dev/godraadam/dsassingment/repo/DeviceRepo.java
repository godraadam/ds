package dev.godraadam.dsassingment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.dsassingment.model.Device;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Long> {
    List<Device> findAllByOwner_Id(Long id);
}
