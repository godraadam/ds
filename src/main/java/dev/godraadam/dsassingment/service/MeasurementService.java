package dev.godraadam.dsassingment.service;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import dev.godraadam.dsassingment.api.assembler.MeasurementAssembler;
import dev.godraadam.dsassingment.api.dto.ws.ClientMessageDTO;
import dev.godraadam.dsassingment.model.AppUser;
import dev.godraadam.dsassingment.model.Measurement;
import dev.godraadam.dsassingment.model.Sensor;
import dev.godraadam.dsassingment.repo.MeasurementRepo;


@Service
public class MeasurementService {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private MeasurementRepo measurementRepo;

    @Autowired
    private SimpMessagingTemplate template;

    public List<Measurement> getMeasurementsForSensor(Long sensorId) {
        return sensorService.getSensorById(sensorId).getMeasurements();
    }

    public List<Measurement> getMeasurementsForSensorBetween(Long sensorId, LocalDateTime from, LocalDateTime to) {
        return measurementRepo.findAllBySensorIdAndTimestampBetween(sensorId, from, to);
    }

    @Autowired
    private MeasurementAssembler measurementAssembler;

    public Measurement saveMeasurement(Measurement measurement) {
        // get last consumption
        Sensor sensor = measurement.getSensor();
        List<Measurement> measurements = sensorService.getSensorById(sensor.getId()).getMeasurements();
        Measurement lastMeasurement;
        AppUser user = sensor.getMonitoredDevice().getOwner();

        //want to send out new measurment to client eagerely
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        ClientMessageDTO dto = new ClientMessageDTO();
        try {
            System.out.println("new measurement, sending..");
            dto.setEvent("new_measurement");
            dto.setContent(objectMapper.writeValueAsString(measurementAssembler.createDTO(measurement)));
            template.convertAndSend("/client/return/" + user.getId(), dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (measurements.isEmpty()) {
            // no data => no peak, return early
            return measurementRepo.save(measurement);
        } else {
            lastMeasurement = measurements.get(measurements.size() - 1);
            Double delta = (measurement.getValue() - lastMeasurement.getValue()) / (lastMeasurement.getTimestamp().until(measurement.getTimestamp(), ChronoUnit.SECONDS));
            if (delta > sensor.getMaxValue()) {
                dto.setEvent("power_peak");
                System.out.println(("power peak"));
                dto.setContent("{\"sensor_id\":" + sensor.getId() + ", \n\"value\":" + measurement.getValue() + "}");
                template.convertAndSend("/client/return/" + user.getId(), dto);

            }
        }
        System.out.println(measurement.getId());
        return  measurementRepo.save(measurement);
    }

}
