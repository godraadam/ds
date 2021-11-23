package dev.godraadam.dsassingment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.dsassingment.exception.ResourceNotFoundException;
import dev.godraadam.dsassingment.model.Device;
import dev.godraadam.dsassingment.model.Sensor;
import dev.godraadam.dsassingment.repo.SensorRepo;

@Service
public class SensorService {

    @Autowired
    private SensorRepo sensorRepo;

    @Autowired
    private DeviceService deviceService;

    public Sensor getSensorById(Long id) {
        return sensorRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Sensor getSensorForDevice(Long deviceId) {
        try {
            Device device = deviceService.getDeviceById(deviceId);
            return device.getSensor();
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }

    public Sensor addSensorToDevice(Sensor sensor, Long deviceId) {
        try {
            Device device = deviceService.getDeviceById(deviceId);
            device.setSensor(sensor);
            device = deviceService.saveDevice(device);
            sensor.setMonitoredDevice(device);
            return sensorRepo.save(sensor);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }

    public void deleteSensor(Long sensorId) {
        Optional<Sensor> sensorOptional = sensorRepo.findById(sensorId);
        if (sensorOptional.isEmpty()) {
            return;
        }
        Device device = sensorOptional.get().getMonitoredDevice();
        device.setSensor(null);
        deviceService.saveDevice(device);
        sensorRepo.deleteById(sensorId);
    }
}
