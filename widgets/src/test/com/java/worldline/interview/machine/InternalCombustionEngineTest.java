package com.java.worldline.interview.machine;

import com.worldline.interview.constant.FuelType;
import com.worldline.interview.machine.InternalCombustionEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InternalCombustionEngineTest {

    private InternalCombustionEngine internalCombustionEngine;

    @BeforeEach
    void setUp() {
        internalCombustionEngine = new InternalCombustionEngine(
                List.of(FuelType.COAL,FuelType.WOOD), FuelType.COAL
        );
    }

    @Test
    public void testStartWithEmptyFuelAndUsingRequiredFuelType(){
        Assertions.assertThrows(IllegalStateException.class, () -> {
            internalCombustionEngine.start();
        });
    }

    @Test
    public void testStartWithEmptyFuelAndUsingNotRequiredFuelType(){
        internalCombustionEngine.fill(FuelType.DIESEL, 0);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            internalCombustionEngine.start();
        });
    }

    @Test
    public void testStartWithHighFuelLevelAndUsingNotRequiredFuelType(){
        internalCombustionEngine.fill(FuelType.DIESEL, 100);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            internalCombustionEngine.start();
        });
    }

    @Test
    public void testStartWithHighFuelLevelAndUsingRequiredFuelType(){
        internalCombustionEngine.fill(FuelType.COAL, 100);
        assertDoesNotThrow(() -> {
            internalCombustionEngine.start();
        } );
    }

    @Test
    public void testStartWithMediumFuelLevelAndUsingRequiredFuelType(){
        internalCombustionEngine.fill(FuelType.COAL, 50);
        assertDoesNotThrow(() -> {
            internalCombustionEngine.start();
        } );
    }

    @Test
    public void testFillWithExpectedResult(){
        // Fill with maximum level
        internalCombustionEngine.fill(FuelType.COAL, 150);
        assertEquals(100, internalCombustionEngine.getFuelLevel());

        // Fill with medium level
        internalCombustionEngine.fill(FuelType.COAL, 45);
        assertEquals(45, internalCombustionEngine.getFuelLevel());

        // Fill with empty level
        internalCombustionEngine.fill(FuelType.COAL, 0);
        assertEquals(0, internalCombustionEngine.getFuelLevel());
    }

}