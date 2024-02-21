package se.lu.ics.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.Shipment;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.Warehouse;
import se.lu.ics.models.WarehouseRegistry;
import javafx.scene.Node;

public class AddWarehouseViewController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;

    @FXML
    private Button buttonAddWarehouse;

    @FXML
    private Button buttonReturn;

    @FXML
    private TextField textfieldWarehouseAddress;

    @FXML
    private TextField textfieldWarehouseCapacity;

    @FXML
    private TextField textfieldWarehouseCurrentStock;

    @FXML
    private TextField textfieldWarehouseName;

    // ---------------------------------------------------------------------------------------


    @FXML
    void handleButtonAddWarehouseAction(ActionEvent event) {

        String name = textfieldWarehouseName.getText();
        String address = textfieldWarehouseAddress.getText();
        int capacity = Integer.parseInt(textfieldWarehouseCapacity.getText());
        int currentStock = Integer.parseInt(textfieldWarehouseCurrentStock.getText());

        Warehouse warehouse = new Warehouse(name, address, capacity, currentStock, null);
        warehouseRegistry.addWarehouse(warehouse);
    }

    @FXML
    void handleButtonReturnAction(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void setWarehouseRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
    }

    public void setShipmentRegistry(ShipmentRegistry shipmentRegistry) {
        this.shipmentRegistry = shipmentRegistry;
    }

    public void setInspectionRegistry(InspectionRegistry inspectionRegistry) {
        this.inspectionRegistry = inspectionRegistry;
    }
    
}
