package se.lu.ics.controllers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import se.lu.ics.models.Inspection;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.ShipmentLogRegistry;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.WarehouseRegistry;
import se.lu.ics.models.Shipment;
import se.lu.ics.models.Warehouse;

public class AddInspectionViewController {

    private ShipmentRegistry shipmentRegistry;
    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentLogRegistry shipmentLogRegistry;

    @FXML
    private Button butonClose;

    @FXML
    private Button buttonConfirm;

    @FXML
    private ChoiceBox<Shipment> choiceboxInspectionShipment;

    @FXML
    private DatePicker datepickerInspection;

    @FXML
    private TextField textfieldInspectionResponsible;

    @FXML
    private TextField textfieldInspectionResult;

    @FXML
    void handleButtonCloseAction(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void handleButtonConfirmAction(ActionEvent event) {
        
        Shipment selectedShipment = choiceboxInspectionShipment.getValue();
        Warehouse currentWarehouse = shipmentLogRegistry.getWarehouse(selectedShipment);
        String date = datepickerInspection.getValue().toString();
        String responsible = textfieldInspectionResponsible.getText();
        String result = textfieldInspectionResult.getText();
        int inspectionId = Integer.parseInt(generateRandomUniqueNumber());

        Inspection inspection = new Inspection(currentWarehouse,selectedShipment, date, responsible, result,inspectionId);
        inspectionRegistry.addInspection(inspection);
        
        textfieldInspectionResponsible.clear();
        textfieldInspectionResult.clear();
        datepickerInspection.getEditor().clear();
        
    }

    public void populateChoiceBox() {
        choiceboxInspectionShipment.getItems().clear();
        choiceboxInspectionShipment.getItems().addAll(shipmentRegistry.getShipmentRegistry());
    }

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

    public void setInspectionRegistry(InspectionRegistry inspectionRegistry) {
        this.inspectionRegistry = inspectionRegistry;
    }

    public void setShipmentRegistry(ShipmentRegistry shipmentRegistry) {
        this.shipmentRegistry = shipmentRegistry;
        populateChoiceBox();
    }

    public void setShipmentLogRegistry(ShipmentLogRegistry shipmentLogRegistry) {
        this.shipmentLogRegistry = shipmentLogRegistry;
    }

}
