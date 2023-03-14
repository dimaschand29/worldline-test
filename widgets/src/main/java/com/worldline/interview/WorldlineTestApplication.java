package com.worldline.interview;

import com.worldline.interview.constant.BatchSizeMachine;
import com.worldline.interview.constant.FuelType;
import com.worldline.interview.machine.SteamMachine;
import com.worldline.interview.machine.WidgetMachine;

public class WorldlineTestApplication {
    public static void main(String[] args) {

        // Initialize widget machine
        WidgetMachine widgetMachine = new WidgetMachine(FuelType.DIESEL, 20);

        // Add fuel level widget machine
        widgetMachine.setFuelLevel(3);

        // Running a widget machine
        System.out.println(widgetMachine.produceWidgets());

        // Initialize steam machine
        SteamMachine steamMachine = new SteamMachine(FuelType.COAL, 20);

        // Add fuel level steam machine
        steamMachine.setFuelLevel(3);

        // Running a steam machine
        System.out.println(steamMachine.produceWidgets());
    }
}
