package com.java.worldline.interview.config;

import com.worldline.interview.config.CommonMachineConfiguration;
import com.worldline.interview.constant.BatchSizeMachine;
import com.worldline.interview.constant.FuelType;
import com.worldline.interview.machine.InternalCombustionEngine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonMachineConfigurationTest {

   private CommonMachineConfiguration commonMachineConfiguration;

    @BeforeEach
    void setUp() {
        commonMachineConfiguration = new CommonMachineConfiguration(FuelType.COAL, BatchSizeMachine.STEAM.batchSize,
                3, List.of(FuelType.COAL,FuelType.WOOD));
    }

    @Test
    public void testProduceWithExpectedResult () throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        int tempQuantity = 8;
        FuelType fuelType = FuelType.DIESEL;
        int batchSize = BatchSizeMachine.WIDGET.batchSize;
        double totalCost = commonMachineConfiguration.produce(tempQuantity, fuelType, batchSize);
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,totalCost);

        tempQuantity = 9;
        totalCost = commonMachineConfiguration.produce(tempQuantity, fuelType, batchSize);
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,totalCost);

        tempQuantity = 10;
        totalCost = commonMachineConfiguration.produce(tempQuantity, fuelType, batchSize);
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,totalCost);

        tempQuantity = 16;
        totalCost = commonMachineConfiguration.produce(tempQuantity, fuelType, batchSize);
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,totalCost);

        tempQuantity = 7;
        totalCost = commonMachineConfiguration.produce(tempQuantity, fuelType, batchSize);
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,totalCost);

        tempQuantity = 1;
        totalCost = commonMachineConfiguration.produce(tempQuantity, fuelType, batchSize);
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,totalCost);

        tempQuantity = 0;
        totalCost = commonMachineConfiguration.produce(tempQuantity, fuelType, batchSize);
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,totalCost);
    }

    @Test
    public void testProduceNotReproduceNegativeValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int tempQuantity = -1000;
        FuelType fuelType = FuelType.DIESEL;
        int batchSize = BatchSizeMachine.WIDGET.batchSize;
        double totalCost = commonMachineConfiguration.produce(tempQuantity, fuelType, batchSize);
        assertNotEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,totalCost);
    }

    @Test
    public void testproduceWidgetsBeforeFilled() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            commonMachineConfiguration.produceWidgets();
        });
    }

    @Test
    public void testproduceWidgetsAfterFilled() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        commonMachineConfiguration.setFuelLevel(3);
        double resultProduceWidgets = assertDoesNotThrow(() -> { return commonMachineConfiguration.produceWidgets(); } );
    }

    @Test
    public void testproduceWidgetsFilledWithDifferentRequieredFuel() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CommonMachineConfiguration commonMachineConfiguration = new CommonMachineConfiguration(FuelType.COAL, BatchSizeMachine.WIDGET.batchSize,
                8, List.of(FuelType.DIESEL,FuelType.PETROL));
        commonMachineConfiguration.setFuelLevel(3);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            commonMachineConfiguration.produceWidgets();
        });
    }

    @Test
    public void testproduceWidgetsExpectedResult() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        commonMachineConfiguration.setFuelLevel(3);
        double totalCost = commonMachineConfiguration.produce(3, FuelType.COAL, BatchSizeMachine.STEAM.batchSize);
        assertEquals(totalCost,commonMachineConfiguration.produceWidgets());
    }

}