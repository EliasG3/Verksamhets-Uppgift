package se.lu.ics.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import se.lu.ics.models.InspectionRegistry;
import se.lu.ics.models.ShipmentLogRegistry;
import se.lu.ics.models.ShipmentRegistry;
import se.lu.ics.models.Warehouse;
import se.lu.ics.models.WarehouseRegistry;

public class OverviewController {

    private WarehouseRegistry warehouseRegistry;
    private InspectionRegistry inspectionRegistry;
    private ShipmentRegistry shipmentRegistry;
    private ShipmentLogRegistry shipmentLogRegistry;

    public void setWarehouseRegistry(WarehouseRegistry warehouseRegistry) {
        this.warehouseRegistry = warehouseRegistry;
        populatePieCharts();
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

    public void initialize() {

    }

    @FXML
    private AnchorPane anchorpanePieChartMiddleCapacity;

    @FXML
    private AnchorPane anchorpanePieChartNorthCapacity;

    @FXML
    private AnchorPane anchorpanePieChartSouthCapacity;

    @FXML
    private AnchorPane anchorpanePieChartTotalCapacity;

    @FXML
    private AnchorPane anchorpaneBarChart;

    @FXML
    private PieChart pieChartMiddleCapacity;

    @FXML
    private PieChart pieChartNorthCapacity;

    @FXML
    private PieChart pieChartSouthCapacity;

    @FXML
    private PieChart pieChartTotalCapacity;

    @FXML
    private NumberAxis xxAxis;

    @FXML
    private CategoryAxis yyAxis;

    @FXML
    private BarChart<String, Integer> barchartCurrentStock;

    public void populateBarChart() {
       XYChart.Series<String, Integer> series = new XYChart.Series();
        for (Warehouse warehouse : warehouseRegistry.getWarehouseRegistry()) {
            series.getData().add(new XYChart.Data<>(warehouse.getName(), warehouse.getCurrentStock()));
        }
        barchartCurrentStock.getData().add(series);
    }


    private void populatePieChartTotalCapacity() {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        int stock = 0;
        int capacity = 0;

        for (Warehouse warehouse : warehouseRegistry.getWarehouseRegistry()) {
            stock += warehouse.getCurrentStock();
            capacity += warehouse.getCapacity();
        }
        pieChartData.add(new PieChart.Data("Stock", stock));
        pieChartData.add(new PieChart.Data("Available Capacity", capacity));
        pieChartTotalCapacity.setData(pieChartData);
    }

    private void populatePieChartMiddleCapacity() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int stock = 0;
        int capacity = 0;

        for (Warehouse warehouse : warehouseRegistry.getWarehouseRegistry()) {
            if (warehouse.getAddress().equals("Middle")) {
                stock += warehouse.getCurrentStock();
                capacity += warehouse.getCapacity();
            }
        }
        pieChartData.add(new PieChart.Data("Stock", stock));
        pieChartData.add(new PieChart.Data("Available Capacity", capacity));
        pieChartMiddleCapacity.setData(pieChartData);
    }

    private void populatePieChartNorthCapacity() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int stock = 0;
        int capacity = 0;

        for (Warehouse warehouse : warehouseRegistry.getWarehouseRegistry()) {
            if (warehouse.getAddress().equals("North")) {
                stock += warehouse.getCurrentStock();
                capacity += warehouse.getCapacity();
            }
        }
        pieChartData.add(new PieChart.Data("Stock", stock));
        pieChartData.add(new PieChart.Data("Available Capacity", capacity));
        pieChartNorthCapacity.setData(pieChartData);
    }

    private void populatePieChartSouthCapacity() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int stock = 0;
        int capacity = 0;

        for (Warehouse warehouse : warehouseRegistry.getWarehouseRegistry()) {
            if (warehouse.getAddress().equals("South")) {
                stock += warehouse.getCurrentStock();
                capacity += warehouse.getCapacity();
            }
        }
        pieChartData.add(new PieChart.Data("Stock", stock));
        pieChartData.add(new PieChart.Data("Available Capacity", capacity));
        pieChartSouthCapacity.setData(pieChartData);
    }

    public void populatePieCharts() {
        populatePieChartMiddleCapacity();
        populatePieChartNorthCapacity();
        populatePieChartSouthCapacity();
        populatePieChartTotalCapacity();
        populateBarChart();
    }

}
