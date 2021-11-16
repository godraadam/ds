package dev.godraadam.dsassingment.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.dsassingment.model.Measurement;
import dev.godraadam.dsassingment.repo.MeasurementRepo;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepo measurementRepo;


}
