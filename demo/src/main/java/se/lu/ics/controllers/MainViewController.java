package se.lu.ics.controllers;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.Warehouse;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.lu.ics.models.WarehouseRegistry;

public class MainViewController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;

    @FXML
    private AnchorPane anchorpanLeft;

    @FXML
    private AnchorPane anchorpaneCenter;

    @FXML
    private AnchorPane anchorpaneLarge;

    @FXML
    private AnchorPane anchorpaneWarehouses;

    @FXML
    private Button buttonAddWarehouse;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonShipments;

    @FXML
    private Button buttonWarehouses;

    @FXML
    private HBox hBoxTopLabel;

    @FXML
    private TableColumn<Warehouse, String> tableColumnWarehousesAddress;

    @FXML
    private TableColumn<Warehouse, Integer> tableColumnWarehousesCapacity;

    @FXML
    private TableColumn<Warehouse, Integer> tableColumnWarehousesCurrentStock;

    @FXML
    private TableColumn<Warehouse, String> tableColumnWarehousesLastInsDate;

    @FXML
    private TableColumn<Warehouse, String> tableColumnWarehousesName;

    @FXML
    private TableView<Warehouse> tableViewWarehouses;

    @FXML
    private TextField textFieldSearchWarehouse;

    @FXML
    private VBox vBoxLeftButtons;

    public void initialize() {

        tableColumnWarehousesAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableColumnWarehousesCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        tableColumnWarehousesCurrentStock.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        tableColumnWarehousesLastInsDate.setCellValueFactory(new PropertyValueFactory<>("lastInspectionDate"));
        tableColumnWarehousesName.setCellValueFactory(new PropertyValueFactory<>("name"));

        tableColumnWarehousesAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnWarehousesCapacity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnWarehousesCurrentStock
                .setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnWarehousesLastInsDate.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnWarehousesName.setCellFactory(TextFieldTableCell.forTableColumn());

        tableColumnWarehousesAddress.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setAddress(event.getNewValue());
        });

        tableColumnWarehousesCapacity.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setCapacity(event.getNewValue());
        });

        tableColumnWarehousesCurrentStock.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setCurrentStock(event.getNewValue());
        });

        tableColumnWarehousesLastInsDate.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setLastInspectionDate(event.getNewValue());
        });

        tableColumnWarehousesName.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setName(event.getNewValue());
        });

    }

    @FXML
    void handleButtonAddWarehouseAction(ActionEvent event) {

    }

    @FXML
    void handleButtonDeleteAction(ActionEvent event) {

    }

    @FXML
    void handleButtonShipmentsAction(ActionEvent event) {

    }

    @FXML
    void handleButtonWarehousesAction(ActionEvent event) {

    }

    public void populateTableView() {
        ObservableList<Warehouse> warehouses = FXCollections.observableArrayList();
        if (warehouseRegistry != null) {
            warehouses.addAll(warehouseRegistry.getWarehouseRegistry());
            tableViewWarehouses.setItems(warehouses);
        }
    }

    public void setShipmentRegistry(ShipmentRegistry shipmentRegistry) {
        this.shipmentRegistry = shipmentRegistry;
    }

    public void setWarehouseRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
        populateTableView();
    }

    public void setInspectionRegistry(InspectionRegistry inspectionRegistry) {
        this.inspectionRegistry = inspectionRegistry;
    }
}
