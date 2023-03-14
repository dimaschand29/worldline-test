package com.worldline.interview;

import com.worldline.interview.constant.BatchSizeMachine;
import com.worldline.interview.constant.FuelType;
import com.worldline.interview.machine.SteamMachine;
import com.worldline.interview.machine.WidgetMachine;

public class WorldlineTestApplication {
    public static void main(String[] args) {

        // Initialize machine widget
        WidgetMachine widgetMachine = new WidgetMachine(FuelType.DIESEL, 20);

        // Add fuel level
        widgetMachine.setFuelLevel(3);

        // Running a machine
        System.out.println(widgetMachine.produceWidgets());

        // Initialize machine widget
        SteamMachine steamMachine = new SteamMachine(FuelType.COAL, 20);

        // Add fuel level
        steamMachine.setFuelLevel(3);

        // Running a machine
        System.out.println(steamMachine.produceWidgets());
    }
}
