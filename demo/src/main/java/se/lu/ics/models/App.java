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
        primaryStage.show();
    }

    public void addTestData() {

        Warehouse warehouse1 = new Warehouse("Warehouse 1", "Address 1", 100, 50, "2020-01-01");
        Warehouse warehouse2 = new Warehouse("Warehouse 2", "Address 2", 200, 100, "2020-01-01");
        Warehouse warehouse3 = new Warehouse("Warehouse 3", "Address 3", 300, 150, "2020-01-01");

        this.warehouseRegistry.addWarehouse(warehouse1);
        this.warehouseRegistry.addWarehouse(warehouse2);
        this.warehouseRegistry.addWarehouse(warehouse3);

        Inspection inspection1 = new Inspection(warehouse1, "2020-01-01", "John Doe", "OK", 1);
        Inspection inspection2 = new Inspection(warehouse2, "2020-01-01", "John Doe", "OK", 2);
        Inspection inspection3 = new Inspection(warehouse3, "2020-01-01", "John Doe", "OK", 3);

        this.shipmentRegistry.addShipment(new Shipment(inspection1, "Recieving", 1, 10));
        this.shipmentRegistry.addShipment(new Shipment(inspection2, "Recieving", 2, 20));
        this.shipmentRegistry.addShipment(new Shipment(inspection3, "Recieving", 3, 30));
       
    }

}
