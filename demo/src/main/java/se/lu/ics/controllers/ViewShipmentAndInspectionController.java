package se.lu.ics.controllers;

import java.util.Observable;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import se.lu.ics.models.Inspection;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.Shipment;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.WarehouseRegistry;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.lu.ics.models.Warehouse;
import javafx.scene.input.MouseEvent;

public class ViewShipmentAndInspectionController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;
    private Warehouse selectedWarehouse;
    private MainViewController mainViewController;

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

    @FXML
    public void initialize() {

        tablecolumnInspectionDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tablecolumnInspectionID.setCellValueFactory(new PropertyValueFactory<>("inspectionId"));
        tablecolumnInspectionResponsible.setCellValueFactory(new PropertyValueFactory<>("responsible"));
        tablecolumnInspectionResult.setCellValueFactory(new PropertyValueFactory<>("result"));
        tablecolumnShipmentDSACL.setCellValueFactory(new PropertyValueFactory<>("daysStored"));
        tablecolumnShipmentID.setCellValueFactory(new PropertyValueFactory<>("shipmentId"));
        tablecolumnShipmentType.setCellValueFactory(new PropertyValueFactory<>("type"));

        tablecolumnInspectionDate.setCellFactory(TextFieldTableCell.forTableColumn());
        tablecolumnInspectionID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tablecolumnInspectionResponsible.setCellFactory(TextFieldTableCell.forTableColumn());
        tablecolumnInspectionResult.setCellFactory(TextFieldTableCell.forTableColumn());
        tablecolumnShipmentDSACL.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tablecolumnShipmentID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tablecolumnShipmentType.setCellFactory(TextFieldTableCell.forTableColumn());

        tablecolumnInspectionDate.setOnEditCommit(event -> {
            Inspection inspection = event.getRowValue();
            inspection.setDate(event.getNewValue());
        });

        tablecolumnInspectionID.setOnEditCommit(event -> {
            Inspection inspection = event.getRowValue();
            inspection.setInspectionId(event.getNewValue());
        });

        tablecolumnInspectionResponsible.setOnEditCommit(event -> {
            Inspection inspection = event.getRowValue();
            inspection.setResponsible(event.getNewValue());
        });

        tablecolumnInspectionResult.setOnEditCommit(event -> {
            Inspection inspection = event.getRowValue();
            inspection.setResult(event.getNewValue());
        });

        tablecolumnShipmentDSACL.setOnEditCommit(event -> {
            Shipment shipment = event.getRowValue();
            shipment.setDaysStored(event.getNewValue());
        });

        tablecolumnShipmentID.setOnEditCommit(event -> {
            Shipment shipment = event.getRowValue();
            shipment.setShipmentId(event.getNewValue());
        });

        tablecolumnShipmentType.setOnEditCommit(event -> {
            Shipment shipment = event.getRowValue();
            shipment.setType(event.getNewValue());
        });
    }

    private Shipment getSelectedShipment() {
        Shipment selectedShipment = tableviewSpecificShipments.getSelectionModel().getSelectedItem();
        return selectedShipment;
    }

    public void populateTableViewShipments() {
        tableviewSpecificShipments.setItems(selectedWarehouse.getShipments());
    }

    public void populateTableViewInspections() {
        ObservableList<Inspection> inspections = FXCollections.observableArrayList(getSelectedShipment().getInspection());
        tableviewInspection.setItems(inspections);
    }
    
    @FXML
    void viewInspections(MouseEvent event) {
        populateTableViewInspections();
    }

    //----------------------------------------------------------------------------

    @FXML
    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }

    public void setSelectedWarehouse(Warehouse selectedWarehouse) {
        this.selectedWarehouse = selectedWarehouse; 
        populateTableViewShipments();
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
