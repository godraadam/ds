package dev.godraadam.dsassingment.service.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.api.assembler.MeasurementAssembler;
import dev.godraadam.dsassingment.api.dto.MeasurementDTO;
import dev.godraadam.dsassingment.model.Measurement;
import dev.godraadam.dsassingment.service.MeasurementService;

@Component
public class SensorDataConsumer {

    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private MeasurementAssembler measurementAssembler;

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String body) {
        System.out.println(body);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        MeasurementDTO dto;
        try {
            dto = objectMapper.readValue(body, MeasurementDTO.class);
            Measurement measurement = measurementAssembler.createModel(dto);
            measurementService.saveMeasurement(measurement);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
