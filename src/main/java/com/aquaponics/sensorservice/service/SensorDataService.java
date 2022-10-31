package com.aquaponics.sensorservice.service;

import com.aquaponics.sensorservice.model.SensorData;
import com.aquaponics.sensorservice.repository.SensorDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorDataService {
    private final SensorDataRepository sensorDataRepository;

    public SensorData createSensorData(SensorData sensor) {
        return sensorDataRepository.save(sensor);
    }
}
