package se.lu.ics.models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.lu.ics.controllers.MainViewController;

public class App extends Application {
    
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;
    private WarehouseRegistry warehouseRegistry;
    private ShipmentLogRegistry shipmentLogRegistry;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.inspectionRegistry = new InspectionRegistry();
        this.shipmentRegistry = new ShipmentRegistry();
        this.warehouseRegistry = new WarehouseRegistry();
        this.shipmentLogRegistry = new ShipmentLogRegistry();

        addTestData();

        URL fxml = getClass().getResource("/fxml/MainView2.fxml");
        FXMLLoader loader = new FXMLLoader(fxml);
        Scene scene = new Scene(loader.load());

        MainViewController controller = loader.getController();
        controller.setInspectionRegistry(this.inspectionRegistry);
        controller.setShipmentRegistry(this.shipmentRegistry);
        controller.setWarehouseRegistry(this.warehouseRegistry);
        controller.setShipmentLogRegistry(this.shipmentLogRegistry);

        scene.getStylesheets().add(App.class.getResource("/css/light.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Viking Express Inventory Management System");
        primaryStage.show();
    }

    public void addTestData() {

        Warehouse warehouse1 = new Warehouse("Warehouse 1", "North", 100, 50, "2020-01-01");
        Warehouse warehouse2 = new Warehouse("Warehouse 2", "South", 200, 100, "2020-01-01");
        Warehouse warehouse3 = new Warehouse("Warehouse 3", "Middle", 300, 150, "2020-01-01");

        Shipment shipment1 = new Shipment( "Recieving", 1, 10,9);
        Shipment shipment2 = new Shipment( "Recieving", 2, 20,5);
        Shipment shipment3 = new Shipment( "Recieving", 3, 30,2);
        
        Inspection inspection1 = new Inspection(warehouse1, shipment1, "2020-01-01", "John Doe", "OK", 1);
        Inspection inspection2 = new Inspection(warehouse2,shipment2, "2020-01-01", "John Doe", "OK", 2);
        Inspection inspection3 = new Inspection(warehouse3,shipment3, "2020-01-01", "John Doe", "OK", 3);
        Inspection inspection4 = new Inspection(warehouse1,shipment1, "2020-01-01", "John Doe", "OK", 4);
        Inspection inspection5 = new Inspection(warehouse2,shipment2, "2020-01-01", "John Doe", "OK", 5);
        Inspection inspection6 = new Inspection(warehouse3, shipment3,"2020-01-01", "John Doe", "OK", 6);


        ShipmentLog shipmentLog1 = new ShipmentLog("2020-01-01", warehouse1, shipment1, 1, 10);
        ShipmentLog shipmentLog2 = new ShipmentLog("2020-01-01", warehouse2, shipment2, 2, 20);
        ShipmentLog shipmentLog3 = new ShipmentLog("2020-01-01", warehouse3, shipment3, 3, 30);
        
        warehouse1.addShipment(shipment1);
        warehouse2.addShipment(shipment2);
        warehouse3.addShipment(shipment3);


        this.shipmentLogRegistry.addShipmentLog(shipmentLog1);
        this.shipmentLogRegistry.addShipmentLog(shipmentLog2);
        this.shipmentLogRegistry.addShipmentLog(shipmentLog3);

        this.warehouseRegistry.addWarehouse(warehouse1);
        this.warehouseRegistry.addWarehouse(warehouse2);
        this.warehouseRegistry.addWarehouse(warehouse3);

        this.inspectionRegistry.addInspection(inspection1);
        this.inspectionRegistry.addInspection(inspection2);
        this.inspectionRegistry.addInspection(inspection3);
        this.inspectionRegistry.addInspection(inspection4);
        this.inspectionRegistry.addInspection(inspection5);
        this.inspectionRegistry.addInspection(inspection6);


        this.shipmentRegistry.addShipment(shipment1);
        this.shipmentRegistry.addShipment(shipment2);
        this.shipmentRegistry.addShipment(shipment3);
       
    }

}
