package com.java.worldline.interview.machine;

import com.worldline.interview.constant.BatchSizeMachine;
import com.worldline.interview.constant.FuelType;
import com.worldline.interview.machine.SteamMachine;
import com.worldline.interview.machine.WidgetMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SteamMachineTest {

    private SteamMachine steamMachine;
    private int batchSize = BatchSizeMachine.STEAM.batchSize;
    private FuelType fuelType = FuelType.COAL;
    private int quantity = 10;

    @BeforeEach
    void setUp() {
        steamMachine = new SteamMachine(fuelType, quantity);
    }

    @Test
    public void testStartBeforeFilled (){
        Assertions.assertThrows(IllegalStateException.class, () -> {
            steamMachine.produceWidgets();
        });
    }

    @Test
    public void testStartAfterFilled (){
        steamMachine.setFuelLevel(100);
        double productWidgetsResult = assertDoesNotThrow(() ->
        { return steamMachine.produceWidgets(); } );
    }

    @Test
    public void testFilledWithNotRequiredFuel (){
        steamMachine = new SteamMachine(FuelType.DIESEL, quantity);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            steamMachine.produceWidgets();
        });
    }

    @Test
    public void testProduceSteamWithExpectedResult (){
        steamMachine.setFuelLevel(100);
        int tempQuantity = quantity;
        double productWidgetsResult = steamMachine.produceWidgets();
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,productWidgetsResult);
    }
}