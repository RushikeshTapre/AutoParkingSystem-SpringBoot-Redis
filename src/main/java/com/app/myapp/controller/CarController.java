package com.app.myapp.controller;
import com.app.myapp.pojo.ApiResponse;
import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import com.app.myapp.repository.ICarRepository;
import com.app.myapp.repository.ISlotRepository;
import com.app.myapp.service.ICarService;
import com.app.myapp.service.ISlotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/cars")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Lazy
    @Autowired
    ICarService carService;
    @Lazy
    @Autowired
    ISlotRepository slotRepository;

    public CarController() {
    }

    @GetMapping
    public ResponseEntity<?> getAllCarDetails() {
        try {
            Map<String, Object> response;
            Map<String ,Car> list = null;//carService.getCarList();
            if (!list.isEmpty()) {
                response = new HashMap<String, Object>();
                response.put("message", ApiResponse.generateResponse(true));
                response.put("payload", list);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.info("exception in getAllCarDetails:" + e);
        }
        return new ResponseEntity<>(ApiResponse.generateResponse(false, "car list empty"), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> carEntry(@RequestBody Car newCar) {
        try {
            Map<String, Object> response = new HashMap<>();
            Slot slot = carService.carEntry(newCar);
            if (slot != null) {
                response = new HashMap<String, Object>();
                response.put("message", ApiResponse.generateResponse(true));
                response.put("data", slot);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (RuntimeException e) {
            logger.info("exception in carEntry:" + e);
        }
        return new ResponseEntity<>(ApiResponse.generateResponse(false,"car not found "),HttpStatus.NOT_FOUND);
    }



}

