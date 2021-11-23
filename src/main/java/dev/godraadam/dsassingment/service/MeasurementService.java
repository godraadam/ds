package dev.godraadam.dsassingment.service;


import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.dsassingment.model.Measurement;
import dev.godraadam.dsassingment.repo.MeasurementRepo;


@Service
public class MeasurementService {

    @Autowired
    private SensorService sensorService;

    private Logger logger = LoggerFactory.getLogger(MeasurementService.class);

    @Autowired
    private MeasurementRepo measurementRepo;

    public List<Measurement> getMeasurementsForSensor(Long sensorId) {
        logger.info("received A");
        return sensorService.getSensorById(sensorId).getMeasurements();
    }

    public List<Measurement> getMeasurementsForSensorBetween(Long sensorId, LocalDateTime from, LocalDateTime to) {
        logger.info("received B");
        return measurementRepo.findAllBySensorIdAndTimestampBetween(sensorId, from, to);
    }

}
