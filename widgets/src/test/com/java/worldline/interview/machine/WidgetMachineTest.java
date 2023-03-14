package com.java.worldline.interview.machine;

import com.worldline.interview.config.CommonMachineConfiguration;
import com.worldline.interview.constant.BatchSizeMachine;
import com.worldline.interview.constant.FuelType;
import com.worldline.interview.machine.SteamMachine;
import com.worldline.interview.machine.WidgetMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WidgetMachineTest {

    private WidgetMachine widgetMachine;
    private int batchSize = BatchSizeMachine.WIDGET.batchSize;
    private FuelType fuelType = FuelType.DIESEL;
    private int quantity = 10;

    @BeforeEach
    void setUp() {
        widgetMachine = new WidgetMachine(fuelType, quantity);
    }

    @Test
    public void testStartBeforeFilled (){
        Assertions.assertThrows(IllegalStateException.class, () -> {
            widgetMachine.produceWidgets();
        });
    }

    @Test
    public void testStartAfterFilled (){
        widgetMachine.setFuelLevel(100);
        double productWidgetsResult = assertDoesNotThrow(() ->
        { return widgetMachine.produceWidgets(); } );
    }

    @Test
    public void testFilledWithNotRequiredFuel (){
        widgetMachine = new WidgetMachine(FuelType.COAL, quantity);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            widgetMachine.produceWidgets();
        });
    }

    @Test
    public void testProduceWidgetsWithExpectedResult (){
        widgetMachine.setFuelLevel(100);
        int tempQuantity = quantity;
        double productWidgetsResult = widgetMachine.produceWidgets();
        assertEquals(Math.ceil((double)tempQuantity/batchSize)*fuelType.cost,productWidgetsResult);
    }
}