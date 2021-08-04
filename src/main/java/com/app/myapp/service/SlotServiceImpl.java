package com.app.myapp.service;

import com.app.myapp.pojo.Car;
import com.app.myapp.pojo.Slot;
import com.app.myapp.repository.ISlotRepository;
import com.app.myapp.util.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class SlotServiceImpl implements ISlotService {

    private static final Logger logger= LoggerFactory.getLogger(SlotServiceImpl.class);


    @Autowired
    ISlotRepository slotRepository;

    @Autowired
    private RedisTemplate<String, Slot> slotRedisTemplate;


    private HashOperations hashOperations;


    public SlotServiceImpl(RedisTemplate<String, Slot> slotRedisTemplate ) {
        this.slotRedisTemplate = slotRedisTemplate;
        hashOperations = slotRedisTemplate.opsForHash();
        logger.info("hashOperation:"+hashOperations);
    }

    @Override
    public boolean prepareSlot() {
        Slot newSlot;
        try {
            for (int i = 1; i <= 10; i++) {
                newSlot=new Slot();
                newSlot.setSlotId(String.valueOf(IdGenerator.generateUniqueId()));
                newSlot.setCarId("empty");
                newSlot.setSlotNumber(String.valueOf(i));
                hashOperations.put("SLOT", i ,newSlot);
                logger.info(""+newSlot);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Map<String ,Slot> getAllSlot() {

            Optional<Slot> slot=slotRepository.findById("1047038957");//slotRepository.findByCarId("empty");//slotRepository.findBySlotNumber("6");
            logger.info("AAAA"+slot.toString());
            return hashOperations.entries("SLOT");

    }

}