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
        this.fuelType = super.getFuelType();
    }

    public double produceWidgets() {
        super.start();
        double cost = 0;
        int quantity = this.quantity;
        FuelType fuelType = this.fuelType;
        int batchSize = this.batchSize;

        if (super.isRunning()) {
            System.out.println(this.quantity);
            System.out.println(super.getFuelType());
            System.out.println(batchSize);
            cost = produce(quantity, fuelType, batchSize);
        }

        super.stop();

        return cost;
    }

    private double produce(int quantity, FuelType fuelType, int batchSize) {
        int batch = batchSize;
        int batchCount = 0;
        double costPerBatch = FuelType.valueOf(fuelType.name()).getCost();

        while (batch < quantity) {
            batch = batch+batchCount;
            batchCount++;
            System.out.println("batchCount : "+batchCount);
        }

        return batchCount * costPerBatch;
    }

}
