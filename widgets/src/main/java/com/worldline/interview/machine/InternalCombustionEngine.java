package com.worldline.interview.machine;

import com.worldline.interview.constant.FuelType;

import java.util.List;

public class InternalCombustionEngine {

    private boolean running;
    private int fuelLevel;
    private List<FuelType> requiredFuelType;
    private FuelType fuelType;

    public InternalCombustionEngine(List <FuelType> requiredFuelType, FuelType fuelType) {
        this.requiredFuelType = requiredFuelType;
        this.fuelType = fuelType;
        running = false;
    }

    public void start() {
        if (fuelLevel > 0 && requiredFuelType.contains(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setFuelLevel(int fuelLevel){
        this.fuelLevel = fuelLevel;
    }
}
