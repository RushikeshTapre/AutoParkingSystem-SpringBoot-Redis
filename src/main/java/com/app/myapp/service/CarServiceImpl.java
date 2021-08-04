package com.app.myapp.service;

import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import com.app.myapp.repository.ICarRepository;
import com.app.myapp.repository.ISlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {


    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Lazy
    @Autowired
    ICarRepository carRepository;

    @Lazy
    @Autowired
    ISlotRepository slotRepository;

    @Autowired
    private RedisTemplate<String, Car> carRedisTemplate;
    @Autowired
    private RedisTemplate<String, Slot> slotRedisTemplate;

    private HashOperations carHashOperations, slotHashOperations;

    public CarServiceImpl() {
        logger.info("In CarServiceImpl");
    }

    @Override
    public List<Car> getCarList() {

        return null;
    }

    @Override
    public Slot carEntry(Car car) {
        try {
            Slot slot = null;//slotRepository.findByCarId("empty");//slotRepository.findByCarId("empty");
            logger.info("AAAAA"+slot);
        } catch (Exception e) {

        }
        return null;
    }
}