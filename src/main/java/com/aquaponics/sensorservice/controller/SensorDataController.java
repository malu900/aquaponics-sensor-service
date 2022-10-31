package com.aquaponics.sensorservice.controller;

import com.aquaponics.sensorservice.model.SensorData;
import com.aquaponics.sensorservice.repository.SensorDataRepository;
import com.aquaponics.sensorservice.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "sensor")
public class SensorDataController {
    private final SensorDataService sensorService;
    private final SensorDataRepository sensorRepository;

    @GetMapping
    public ResponseEntity<List<SensorData>> getSensors() {
        List<SensorData> sensorData = sensorRepository.findAll();
        if(sensorData.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(sensorData);
        return ResponseEntity.ok().body(sensorData);
    }
    @PostMapping
    public ResponseEntity<SensorData> createSensor(@RequestBody SensorData sensorData) {
        SensorData data = sensorService.createSensorData(sensorData);
        if(data == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
}
