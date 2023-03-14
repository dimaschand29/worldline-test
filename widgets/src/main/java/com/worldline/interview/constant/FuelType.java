package com.worldline.interview.constant;

public enum FuelType {
    PETROL(9.00),
    DIESEL(12.00),
    WOOD(4.35),
    COAL(5.65);

    public double cost;

    FuelType(double cost) {
        this.cost = cost;
    }

    public double getCost(){
        return cost;
    }
}
