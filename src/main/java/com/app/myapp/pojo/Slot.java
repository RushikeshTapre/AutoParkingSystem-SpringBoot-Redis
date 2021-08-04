package com.app.myapp.pojo;


import com.sun.corba.se.spi.ior.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@Builder
@RedisHash("slot")
public class Slot implements Serializable {

    @Id
    private String slotId;
    @Indexed
    private String slotNumber;
    @Indexed
    private String carId;

    public Slot() {
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId='" + slotId + '\'' +
                ", slotNumber='" + slotNumber + '\'' +
                ", carId='" + carId + '\'' +
                '}';
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
