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

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.inspectionRegistry = new InspectionRegistry();
        this.shipmentRegistry = new ShipmentRegistry();
        this.warehouseRegistry = new WarehouseRegistry();

        addTestData();

        URL fxml = getClass().getResource("/fxml/MainView2.fxml");
        FXMLLoader loader = new FXMLLoader(fxml);
        Scene scene = new Scene(loader.load());

        MainViewController controller = loader.getController();
        controller.setInspectionRegistry(this.inspectionRegistry);
        controller.setShipmentRegistry(this.shipmentRegistry);
        controller.setWarehouseRegistry(this.warehouseRegistry);

        scene.getStylesheets().add(App.class.getResource("/css/light.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Viking Express Inventory Management System");
        primaryStage.show();
    }

    public void addTestData() {

        Warehouse warehouse1 = new Warehouse("Warehouse 1", "Address 1", 100, 50, "2020-01-01");
        Warehouse warehouse2 = new Warehouse("Warehouse 2", "Address 2", 200, 100, "2020-01-01");
        Warehouse warehouse3 = new Warehouse("Warehouse 3", "Address 3", 300, 150, "2020-01-01");
        
        Inspection inspection1 = new Inspection(warehouse1, "2020-01-01", "John Doe", "OK", 1);
        Inspection inspection2 = new Inspection(warehouse2, "2020-01-01", "John Doe", "OK", 2);
        Inspection inspection3 = new Inspection(warehouse3, "2020-01-01", "John Doe", "OK", 3);

        Shipment shipment1 = new Shipment(inspection1, "Recieving", 1, 10);
        Shipment shipment2 = new Shipment(inspection2, "Recieving", 2, 20);
        Shipment shipment3 = new Shipment(inspection3, "Recieving", 3, 30);

        ShipmentLog shipmentLog1 = new ShipmentLog("2020-01-01", warehouse1, shipment1);
        ShipmentLog shipmentLog2 = new ShipmentLog("2020-01-01", warehouse2, shipment2);
        ShipmentLog shipmentLog3 = new ShipmentLog("2020-01-01", warehouse3, shipment3);

        shipment1.addShipmentLog(shipmentLog1);
        shipment2.addShipmentLog(shipmentLog2);
        shipment3.addShipmentLog(shipmentLog3);

        warehouse1.addShipment(shipment3);
        warehouse2.addShipment(shipment2);
        warehouse3.addShipment(shipment1);

        this.warehouseRegistry.addWarehouse(warehouse1);
        this.warehouseRegistry.addWarehouse(warehouse2);
        this.warehouseRegistry.addWarehouse(warehouse3);
        

        this.inspectionRegistry.addInspection(inspection1);
        this.inspectionRegistry.addInspection(inspection2);
        this.inspectionRegistry.addInspection(inspection3);

        this.shipmentRegistry.addShipment(shipment1);
        this.shipmentRegistry.addShipment(shipment2);
        this.shipmentRegistry.addShipment(shipment3);


       
    }

}
