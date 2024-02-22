package se.lu.ics.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.Shipment;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.WarehouseRegistry;

public class ShipmentViewController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;

    @FXML
    private Button buttonAddShipment;

    @FXML
    private Button buttonDeleteShipment;

    @FXML
    private TableColumn<Shipment, Integer> tableColumnShipmentDSACL;

    @FXML
    private TableColumn<Shipment, Integer> tableColumnShipmentID;

    @FXML
    private TableColumn<Shipment, String> tableColumnShipmentLastInspection;

    @FXML
    private TableColumn<Shipment, String> tableColumnShipmentType;

    @FXML
    private TableView<Shipment> tableViewShipments;

    @FXML
    private TextField textfieldSearchShipments;
    

    @FXML
    void handleButtonAddShipmentAction(ActionEvent event) {

    }

    @FXML
    void handleButtonDeleteShipmentAction(ActionEvent event) {

    }

    @FXML
    void handleSearchAction(KeyEvent event) {

    }

    public void setWarehouseRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
    }

    public void setInspectionRegistry(InspectionRegistry inspectionRegistry) {
        this.inspectionRegistry = inspectionRegistry;
    }

    public void setShipmentRegistry(ShipmentRegistry shipmentRegistry) {
        this.shipmentRegistry = shipmentRegistry;
    }

}
