package dev.godraadam.dsassingment.api.rpc.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.godraadam.dsassingment.api.rpc.RpcController;
import dev.godraadam.dsassingment.service.MeasurementService;

public class RpcControllerImpl implements RpcController {

    @Autowired
    private MeasurementService measurementService;

    private static final Long DEFAULT_NUMBER_OF_DAYS = 7L;

    @Override
    public List<Double> getPastNDaysBaseline(Long userId, Long numberOfDays) {
        return measurementService.getBaselineForUser(userId, LocalDateTime.now().minusDays(numberOfDays));
    }

    @Override
    public List<Double> getPast7DaysBaseline(Long userId) {
        return getPastNDaysBaseline(userId, DEFAULT_NUMBER_OF_DAYS);
    }

    @Override
    public List<Double> getEstimation(Long interval, Long deviceId) {
        return null;
    }
}
