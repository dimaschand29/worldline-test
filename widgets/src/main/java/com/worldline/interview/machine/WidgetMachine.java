package com.worldline.interview.machine;

import com.worldline.interview.config.CommonMachineConfiguration;
import com.worldline.interview.constant.BatchSizeMachine;
import com.worldline.interview.constant.FuelType;

import java.util.List;

public class WidgetMachine extends CommonMachineConfiguration {

    public WidgetMachine(FuelType fuelType, int quantity) {
        super(fuelType, BatchSizeMachine.WIDGET.batchSize, quantity, List.of(FuelType.PETROL, FuelType.DIESEL));
    }
}
