package se.lu.ics.controllers;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.Shipment;
import se.lu.ics.models.ShipmentLog;
import se.lu.ics.models.ShipmentLogRegistry;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.WarehouseRegistry;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.beans.property.SimpleStringProperty;

public class ShipmentViewController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;
    private ShipmentLogRegistry shipmentLogRegistry;

    @FXML
    private Button buttonAddShipment;

    @FXML
    private Button buttonBookInspection;

    @FXML
    private Button buttonDeleteShipment;

    @FXML
    private Label labelListed;

    @FXML
    private TableColumn<Shipment, Integer> tableColumnShipmentDSACL; // Days Stored At Current Location

    @FXML
    private TableColumn<Shipment, Integer> tableColumnShipmentID;

    @FXML
    private TableColumn<Shipment, String> tableColumnShipmentType; // Recieving or outgoing

    @FXML
    private TableColumn<Shipment, String> tableColumnShipmentWarehouse; // Current warehouse/location

    @FXML
    private TableView<Shipment> tableViewShipments;

    @FXML
    private TextField textfieldSearchShipments;

    public void initialize() {

        updateListedLabel();

        tableColumnShipmentID.setCellValueFactory(new PropertyValueFactory<>("shipmentId"));
        tableColumnShipmentType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableColumnShipmentDSACL.setCellValueFactory(new PropertyValueFactory<>("daysStored"));
        tableColumnShipmentID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnShipmentType.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnShipmentDSACL.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tableColumnShipmentWarehouse.setCellValueFactory(cellData -> new SimpleStringProperty(
            String.valueOf(shipmentLogRegistry.getLastLocation(cellData.getValue()))));


       

        tableColumnShipmentID.setOnEditCommit(event -> {
            Shipment shipment = event.getRowValue();
            shipment.setShipmentId(event.getNewValue());
        });

        tableColumnShipmentType.setOnEditCommit(event -> {
            Shipment shipment = event.getRowValue();
            shipment.setType(event.getNewValue());
        });

        tableColumnShipmentDSACL.setOnEditCommit(event -> {
           Shipment shipment = event.getRowValue();
            for(ShipmentLog shipmentLog : shipmentLogRegistry.getShipmentLogRegistry()){
                if(shipmentLog.getShipment().equals(shipment)){
                    shipmentLog.setDaysStored(event.getNewValue());
                    shipment.setDaysStored(event.getNewValue());
                }
            }
        });

    }

    public void populateTableView() {
        ObservableList<Shipment> shipments = FXCollections.observableArrayList(shipmentRegistry.getShipmentRegistry());
        tableViewShipments.setItems(shipments);
    }

    @FXML
    void handleButtonAddShipmentAction(ActionEvent event) {

    }

    @FXML
    void handleButtonDeleteShipmentAction(ActionEvent event) {
        Shipment shipment = tableViewShipments.getSelectionModel().getSelectedItem();
        if (shipment != null) {
            shipmentRegistry.removeShipment(shipment);
            tableViewShipments.getItems().remove(shipment);
            populateTableView();
            updateListedLabel();
        }
    }

    @FXML
    void handleSearchAction(KeyEvent event) {
        ObservableList<Shipment> shipments = shipmentRegistry.getShipmentRegistry();

        textfieldSearchShipments.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Shipment> filteredList = FXCollections.observableArrayList();
            if(newValue == null || newValue.isEmpty()){
                populateTableView();
                updateListedLabel();
                return;
            }

            for (Shipment shipment : shipments) {
                if (shipment.getShipmentId() == Integer.parseInt(newValue)){
                    filteredList.add(shipment);
                }
            }
            tableViewShipments.getItems().clear();
            tableViewShipments.setItems(filteredList);
            updateListedLabel();
        });
    }

    @FXML
    void handlebuttonBookInspectionAction(ActionEvent event) {

         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddInspectionView.fxml"));
            Stage modalstage = new Stage();
            modalstage.setScene(new Scene(loader.load()));

            modalstage.getScene().getStylesheets().add(getClass().getResource("/css/light.css").toExternalForm());
            AddInspectionViewController controller = loader.getController();
            controller.setWarehouseRegistry(warehouseRegistry);
            controller.setInspectionRegistry(inspectionRegistry);
            controller.setShipmentRegistry(shipmentRegistry);
            controller.setShipmentLogRegistry(shipmentLogRegistry);

            modalstage.setTitle("Book Inspection");
            modalstage.initModality(Modality.APPLICATION_MODAL);
            modalstage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    private void updateListedLabel() {
        labelListed.setText( tableViewShipments.getItems().size()+" Listed" );
    }

    public void setWarehouseRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
    }

    public void setInspectionRegistry(InspectionRegistry inspectionRegistry) {
        this.inspectionRegistry = inspectionRegistry;
    }

    public void setShipmentRegistry(ShipmentRegistry shipmentRegistry) {
        this.shipmentRegistry = shipmentRegistry;
        populateTableView();
        updateListedLabel();
    }

    public void setShipmentLogRegistry(ShipmentLogRegistry shipmentLogRegistry) {
        this.shipmentLogRegistry = shipmentLogRegistry;
    }

}
