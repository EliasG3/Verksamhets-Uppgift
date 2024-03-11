package se.lu.ics.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.ShipmentLogRegistry;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.Warehouse;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.IntegerStringConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.lu.ics.models.WarehouseRegistry;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.util.Duration;
import javafx.event.EventHandler;

public class MainViewController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;
    private ShipmentLogRegistry shipmentLogRegistry;

    @FXML
    private AnchorPane anchorpaneLeftSide;

    @FXML
    private ScrollPane scrollPaneCenter;

    @FXML
    private ScrollPane scrollpaneRight;

    @FXML
    private AnchorPane anchorpaneCenter;

    @FXML
    private AnchorPane anchorpaneLeftButtons;

    @FXML
    private AnchorPane anchorpaneWarehouses;

    @FXML
    private AnchorPane anchorpaneViewShipmentAndInspection;

    @FXML
    private Button buttonClose;

    @FXML
    private Button buttonOverview;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonShupments;

    @FXML
    private Button buttonWarehouses;

    @FXML
    private Button buttonViewShipments;

    @FXML
    private Label labelClock;

    @FXML
    private Label labelListed;

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

    @FXML
    private SplitPane splitpane;

    @FXML
    private VBox largeVBox;


    // ---------------------------------------------------------------------------------------

    public void initialize() {

        populateCurrentDateAndTime();
        updateListedLabel();
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                populateCurrentDateAndTime();
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        tableColumnWarehouseAddress.setCellValueFactory(new PropertyValueFactory<Warehouse, String>("address"));
        tableColumnWarehouseCapacity.setCellValueFactory(new PropertyValueFactory<Warehouse, Integer>("capacity"));
        tableColumnWarehouseCurrentStock
                .setCellValueFactory(new PropertyValueFactory<Warehouse, Integer>("currentStock"));
        tableColumnWarehouseLastInsDate
                .setCellValueFactory(new PropertyValueFactory<Warehouse, String>("lastInspectionDate"));
        tableColumnWarehouseName.setCellValueFactory(new PropertyValueFactory<Warehouse, String>("name"));

        tableColumnWarehouseAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnWarehouseCapacity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tableColumnWarehouseCurrentStock
                .setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
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





        
        tableColumnWarehouseName.setCellValueFactory(new PropertyValueFactory<>("name"));

        tableColumnWarehouseName.setCellFactory(TextFieldTableCell.forTableColumn());

        tableColumnWarehouseName.setOnEditCommit(event -> {
            Warehouse warehouse = event.getRowValue();
            warehouse.setName(event.getNewValue());
        });







    }

    
    public Warehouse getSelectedWarehouse() {
        return tableViewWarehouses.getSelectionModel().getSelectedItem();
    }

    public void populateCurrentDateAndTime() {
        LocalDateTime time = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = time.format(formatter);

        labelClock.setText(formattedDateTime);
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
            controller.setShipmentLogRegistry(shipmentLogRegistry);

            modalstage.initModality(Modality.APPLICATION_MODAL);
            modalstage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
        populateTableView();
        updateListedLabel();
    }

    @FXML
    void handleButtonDeleteAction(ActionEvent event) {

        Warehouse warehouse = tableViewWarehouses.getSelectionModel().getSelectedItem();
        if (warehouse != null) {
            warehouseRegistry.removeWarehouse(warehouse);
            tableViewWarehouses.getItems().remove(warehouse);
            populateTableView();
            updateListedLabel();
        }
    }

    @FXML
    void handleSearchAction(KeyEvent event) {
        ObservableList<Warehouse> warehouses = warehouseRegistry.getWarehouseRegistry();

        textfieldSearchWarehouses.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Warehouse> filteredWarehouses = FXCollections.observableArrayList();

            if (newValue.isEmpty()) {
                populateTableView();
                updateListedLabel();
                return;
            }

            for (Warehouse warehouse : warehouses) {
                if (warehouse.getName().toLowerCase().contains(newValue.toLowerCase())) {
                    filteredWarehouses.add(warehouse);
                }
            }
            tableViewWarehouses.getItems().clear();
            tableViewWarehouses.setItems(filteredWarehouses);
            updateListedLabel();
        });
    }

    @FXML
    void handleButtonCloseAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void handlebuttonViewShipmentsAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewShipmentAndInspectionView.fxml"));
            Parent root = loader.load();
            ViewShipmentAndInspectionController controller = loader.getController();

            root.getStylesheets().add(getClass().getResource("/css/light.css").toExternalForm());
            controller.setShipmentRegistry(shipmentRegistry);
            controller.setInspectionRegistry(inspectionRegistry);
            controller.setWarehouseRegistry(warehouseRegistry);
            controller.setShipmentLogRegistry(shipmentLogRegistry);

            controller.setMainViewController(this);
            controller.setSelectedWarehouse(getSelectedWarehouse());
            
            scrollpaneRight.setContent(root);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // ---------------------------------------------------------------------------------------

    @FXML
    void handleButtonOverviewAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Overview.fxml"));
            Parent root = loader.load();
            OverviewController controller = loader.getController();

            root.getStylesheets().add(getClass().getResource("/css/light.css").toExternalForm());
            controller.setShipmentRegistry(shipmentRegistry);
            controller.setInspectionRegistry(inspectionRegistry);
            controller.setWarehouseRegistry(warehouseRegistry);
            controller.setShipmentLogRegistry(shipmentLogRegistry);

            scrollPaneCenter.setContent(root);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleButtonShipmentsAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShipmentsView.fxml"));
            Parent root = loader.load();
            ShipmentViewController controller = loader.getController();

            root.getStylesheets().add(getClass().getResource("/css/light.css").toExternalForm());
            controller.setShipmentRegistry(shipmentRegistry);
            controller.setInspectionRegistry(inspectionRegistry);
            controller.setWarehouseRegistry(warehouseRegistry);
            controller.setShipmentLogRegistry(shipmentLogRegistry);

            scrollPaneCenter.setContent(root);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleButtonWarehousesAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView2.fxml"));
            Parent root = loader.load();
            MainViewController controller = loader.getController();

            root.getStylesheets().add(getClass().getResource("/css/light.css").toExternalForm());
            controller.setWarehouseRegistry(warehouseRegistry);
            controller.setInspectionRegistry(inspectionRegistry);
            controller.setShipmentRegistry(shipmentRegistry);
            controller.setShipmentLogRegistry(shipmentLogRegistry);
            
            scrollPaneCenter.setContent(anchorpaneWarehouses);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void populateTableView() {
        ObservableList<Warehouse> warehouses = FXCollections
                .observableArrayList(warehouseRegistry.getWarehouseRegistry());
        tableViewWarehouses.setItems(warehouses);
    }

    private void updateListedLabel() {
        labelListed.setText( tableViewWarehouses.getItems().size() +" Listed" );
    }

    public void setWarehouseRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
        populateTableView();
        updateListedLabel();
    }

    public void setInspectionRegistry(InspectionRegistry inspectionRegistry) {
        this.inspectionRegistry = inspectionRegistry;
    }

    public void setShipmentRegistry(ShipmentRegistry shipmentRegistry) {
        this.shipmentRegistry = shipmentRegistry;
    }

    public void setShipmentLogRegistry(ShipmentLogRegistry shipmentLogRegistry) {
        this.shipmentLogRegistry = shipmentLogRegistry;
    }

}
