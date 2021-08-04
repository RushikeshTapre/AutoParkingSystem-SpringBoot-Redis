package com.app.myapp.repository;

import com.app.myapp.pojo.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ISlotRepository extends CrudRepository<Slot,String> {


    Slot findByCarId(String carId);

    Slot findBySlotNumber(String s);
}
