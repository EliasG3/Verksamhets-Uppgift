package se.lu.ics.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import se.lu.ics.models.Inspection;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.Shipment;
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
    private TableColumn<Inspection, String> tablecolumnInspectionDate;

    @FXML
    private TableColumn<Inspection, Integer> tablecolumnInspectionID;

    @FXML
    private TableColumn<Inspection, String> tablecolumnInspectionResponsible;

    @FXML
    private TableColumn<Inspection, String> tablecolumnInspectionResult;


    @FXML
    private TableColumn<Shipment, Integer> tablecolumnShipmentDSACL;

    @FXML
    private TableColumn<Shipment, Integer> tablecolumnShipmentID;

    @FXML
    private TableColumn<Shipment, String> tablecolumnShipmentType;


    @FXML
    private TableView<Inspection> tableviewInspection;

    @FXML
    private TableView<Shipment> tableviewSpecificShipments;

    public void initialize() {

        tablecolumnInspectionDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tablecolumnInspectionID.setCellValueFactory(new PropertyValueFactory<>("inspectionId"));
        tablecolumnInspectionResponsible.setCellValueFactory(new PropertyValueFactory<>("responsible"));
        tablecolumnInspectionResult.setCellValueFactory(new PropertyValueFactory<>("result"));
        
        
    }


    //-----------------------------------------------------------------------

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
