package dev.godraadam.dsassingment.api.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.dsassingment.api.assembler.MeasurementAssembler;
import dev.godraadam.dsassingment.api.dto.MeasurementDTO;
import dev.godraadam.dsassingment.service.MeasurementService;


@RestController
@CrossOrigin
public class MeasurementController {

    @Autowired
    private MeasurementAssembler measurementAssembler;

    @Autowired
    private MeasurementService measurementService;

    @GetMapping("api/measurement/{sensorId}")
    public List<MeasurementDTO> getMeasurementsForSensor(@PathVariable Long sensorId) {
        return measurementAssembler.createDTOList(measurementService.getMeasurementsForSensor(sensorId));
    }

    @GetMapping("api/measurement/{sensorId}/between")
    public List<MeasurementDTO> getMeasurementsForSensorBetween(@PathVariable Long sensorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime to) {
        return measurementAssembler.createDTOList(measurementService.getMeasurementsForSensorBetween(sensorId, from, to));
    }
}
