package se.lu.ics.controllers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.WarehouseRegistry;

public class AddShipmentViewController {

    private ShipmentRegistry shipmentRegistry;
    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;

    private String generateRandomUniqueNumber() {
        Set<String> generatedNumbers = new HashSet<>();
        Random random = new Random();

        while (true) {
            // Generate a random 4-digit number
            int randomNumber = 1000000 + random.nextInt(9000000);

            // Convert the integer to a string
            String randomString = String.valueOf(randomNumber);

            // Check if the number is unique
            if (!generatedNumbers.contains(randomString)) {
                generatedNumbers.add(randomString);
                return randomString;
            }
        }
    }


    public void setWarehouseRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
    }

    public void setShipmentRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
    }

    public void setInspectionRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
    }

}
