package dev.godraadam.dsassingment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.dsassingment.api.assembler.SensorAssembler;
import dev.godraadam.dsassingment.api.dto.SensorDTO;
import dev.godraadam.dsassingment.service.SensorService;

@RestController
public class SensorController {

    @Autowired
    private SensorAssembler sensorAssembler;

    @Autowired
    private SensorService sensorService;

    @GetMapping("/api/sensor/{deviceId}")
    public SensorDTO getSensorForDevice(@PathVariable Long deviceId) {
        return sensorAssembler.createDTO(sensorService.getSensorForDevice(deviceId));
    }

    @PostMapping("/admin/api/sensor/add/deviceId")
    public SensorDTO addSensorToDevice(@RequestBody SensorDTO dto, @PathVariable Long deviceId) {
        return sensorAssembler.createDTO(sensorService.addSensorToDevice(sensorAssembler.createModel(dto), deviceId));
    }

    @DeleteMapping("/admin/api/sensor/rm/{sensorId}")
    public void deleteSensor(@PathVariable Long sensorId) {
        sensorService.deleteSensor(sensorId);
    }
}
