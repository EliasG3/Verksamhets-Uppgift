package se.lu.ics.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.WarehouseRegistry;

public class ViewShipmentAndInspectionController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;


    @FXML
    private VBox VBoxShipmentInspection;

    @FXML
    private AnchorPane anchorpaneInspection;

    @FXML
    private AnchorPane anchorpaneShipment;

    @FXML
    private TableColumn<?, ?> tablecolumnInspectionDate;

    @FXML
    private TableColumn<?, ?> tablecolumnInspectionID;

    @FXML
    private TableColumn<?, ?> tablecolumnInspectionResponsible;

    @FXML
    private TableColumn<?, ?> tablecolumnInspectionResult;

    @FXML
    private TableColumn<?, ?> tablecolumnShipmentDSACL;

    @FXML
    private TableColumn<?, ?> tablecolumnShipmentID;

    @FXML
    private TableColumn<?, ?> tablecolumnShipmentType;

    @FXML
    private TableView<?> tableviewInspection;

    

    @FXML
    private TableView<?> tableviewSpecificShipments;

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
