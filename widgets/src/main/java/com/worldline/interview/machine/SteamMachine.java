package com.worldline.interview.machine;

import com.worldline.interview.config.CommonMachineConfiguration;
import com.worldline.interview.constant.BatchSizeMachine;
import com.worldline.interview.constant.FuelType;

import java.util.List;

public class SteamMachine extends CommonMachineConfiguration {

    public SteamMachine(FuelType fuelType, int quantity) {
        super(fuelType, BatchSizeMachine.STEAM.batchSize, quantity, List.of(FuelType.WOOD, FuelType.COAL));
    }
}
