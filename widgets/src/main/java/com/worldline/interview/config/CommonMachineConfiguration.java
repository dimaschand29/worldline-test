package com.worldline.interview.config;

import com.worldline.interview.constant.FuelType;
import com.worldline.interview.machine.InternalCombustionEngine;

import java.util.List;

public class CommonMachineConfiguration extends InternalCombustionEngine {
//    private InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);

    private int batchSize;
    private int quantity;
    private FuelType fuelType;

    public CommonMachineConfiguration(FuelType fuelTypeInput, int batchSize, int quantity
            , List<FuelType> fuelTypeRequieredList){
        super(fuelTypeRequieredList, fuelTypeInput);
        this.batchSize = batchSize;
        this.quantity = quantity;
        this.fuelType = fuelTypeInput;
    }

    public double produceWidgets() {
        super.start();
        double cost = 0;
        int quantity = this.quantity;
        FuelType fuelType = this.fuelType;
        int batchSize = this.batchSize;

        if (super.isRunning()) {
            cost = produce(quantity, fuelType, batchSize);
        }

        super.stop();

        return cost;
    }

    public double produce(int quantity, FuelType fuelType, int batchSize) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = Math.abs(FuelType.valueOf(fuelType.name()).getCost());

        while (batch < Math.abs(quantity)) {
            batch = batch+batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }

}
