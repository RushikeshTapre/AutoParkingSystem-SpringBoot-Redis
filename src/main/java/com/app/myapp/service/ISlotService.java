package com.app.myapp.service;

import com.app.myapp.pojo.Slot;

import java.util.List;
import java.util.Map;

public interface ISlotService {
    public Map<String ,Slot> getAllSlot() ;
    public boolean prepareSlot();

    }
