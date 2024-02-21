package se.lu.ics.controllers;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Modality;

public class MainViewController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;

    @FXML
    private AnchorPane anchorpaneCenter;

    @FXML
    private AnchorPane anchorpaneLeftButtons;

    @FXML
    private AnchorPane anchorpaneWarehouses;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonShupments;

    @FXML
    private Button buttonWarehouses;

    @FXML
    private TableColumn<Warehouse, String> tableColumnWarehouseAddress;

    @FXML
    private TableColumn<Warehouse, Integer> tableColumnWarehouseCapacity;

    @FXML
    private TableColumn<Warehouse, Integer> tableColumnWarehouseCurrentStock;

    @FXML
    private TableColumn<Warehouse, String> tableColumnWarehouseLastInsDate;

    @FXML
    private TableColumn<Warehouse, String> tableColumnWarehouseName;

    @FXML
    private TableView<Warehouse> tableViewWarehouses;

    @FXML
    private TextField textfieldSearchWarehouses;

    @FXML
    private VBox vBoxLeftButtons;

   


    public void initialize(){
        
        tableColumnWarehouseAddress.setCellValueFactory(new PropertyValueFactory<Warehouse, String>("address"));
        tableColumnWarehouseCapacity.setCellValueFactory(new PropertyValueFactory<Warehouse, Integer>("capacity"));
        tableColumnWarehouseCurrentStock.setCellValueFactory(new PropertyValueFactory<Warehouse, Integer>("currentStock"));
        tableColumnWarehouseLastInsDate.setCellValueFactory(new PropertyValueFactory<Warehouse, String>("lastInspectionDate"));
        tableColumnWarehouseName.setCellValueFactory(new PropertyValueFactory<Warehouse, String>("name"));

        tableColumnWarehouseAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnWarehouseCapacity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnWarehouseCurrentStock.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnWarehouseLastInsDate.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnWarehouseName.setCellFactory(TextFieldTableCell.forTableColumn());

        tableColumnWarehouseAddress.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setAddress(event.getNewValue());
        });

        tableColumnWarehouseCapacity.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setCapacity(event.getNewValue());
        });

        tableColumnWarehouseCurrentStock.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setCurrentStock(event.getNewValue());
        });

        tableColumnWarehouseLastInsDate.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setLastInspectionDate(event.getNewValue());
        });

        tableColumnWarehouseName.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setName(event.getNewValue());
        });


    }

    @FXML
    void handleButtonAddAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddWarehouseView.fxml"));
            Stage modalstage = new Stage();
            modalstage.setScene(new Scene(loader.load()));

            modalstage.getScene().getStylesheets().add(getClass().getResource("/css/light.css").toExternalForm());
            AddWarehouseViewController controller = loader.getController();
            controller.setWarehouseRegistry(warehouseRegistry);
            controller.setInspectionRegistry(inspectionRegistry);
            controller.setShipmentRegistry(shipmentRegistry);
            
            modalstage.initModality(Modality.APPLICATION_MODAL);
            modalstage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
       
        populateTableView();

    }

    @FXML
    void handleButtonDeleteAction(ActionEvent event) {

        Warehouse warehouse = tableViewWarehouses.getSelectionModel().getSelectedItem();
        if(warehouse != null){
            warehouseRegistry.removeWarehouse(warehouse);
            tableViewWarehouses.getItems().remove(warehouse);
            populateTableView();
        }
    }


    @FXML
    void handleButtonShipmentsAction(ActionEvent event) {

    }

    @FXML
    void handleButtonWarehousesAction(ActionEvent event) {

    }

    public void populateTableView(){
        ObservableList<Warehouse> warehouses = FXCollections.observableArrayList(warehouseRegistry.getWarehouseRegistry());
        tableViewWarehouses.setItems(warehouses);
    }

    public void setWarehouseRegistry(WarehouseRegistry warehouseRegistry){
        this.warehouseRegistry = warehouseRegistry;
        populateTableView();
    }

    public void setInspectionRegistry(InspectionRegistry inspectionRegistry){
        this.inspectionRegistry = inspectionRegistry;
    }

    public void setShipmentRegistry(ShipmentRegistry shipmentRegistry){
        this.shipmentRegistry = shipmentRegistry;
    }

}
