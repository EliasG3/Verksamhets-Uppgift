package se.lu.ics.controllers;

import java.util.HashMap;
import java.util.Map;

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

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    private AnchorPane anchorpaneBarChart;

    @FXML
    private AnchorPane anchorpanePieChartTotalCapacity;

    @FXML
    private AnchorPane anchorpaneStackedBarChartRegion;

    @FXML
    private PieChart pieChartTotalCapacity;

    @FXML
    private StackedBarChart<String, Integer> stackedBarChartRegionStock;

    @FXML
    private StackedBarChart<String, Integer> stackedBarChartWarehouseStock;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private CategoryAxis xxAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private NumberAxis yyAxis;

    public void initialize() {

    }

    public void populateBarChart() {
        // Reset the chart data
        stackedBarChartWarehouseStock.getData().clear();

        // Create series for stock and capacity
        XYChart.Series<String, Integer> stockSeries = new XYChart.Series<>();
        stockSeries.setName("Current Stock");
        XYChart.Series<String, Integer> capacitySeries = new XYChart.Series<>();
        capacitySeries.setName("Capacity");

        // Populate the series with data
        for (Warehouse warehouse : warehouseRegistry.getWarehouseRegistry()) {
            String category = warehouse.getName(); // Assuming each warehouse is a category
            Integer stock = warehouse.getCurrentStock();
            Integer capacity = warehouse.getCapacity();

            // Subtract stock from capacity for the visualization purposes
            Integer availableCapacity = capacity.intValue() - stock.intValue();

            stockSeries.getData().add(new XYChart.Data<>(category, stock));
            capacitySeries.getData().add(new XYChart.Data<>(category, availableCapacity));
        }

        // Add series to chart
        stackedBarChartWarehouseStock.getData().addAll(stockSeries, capacitySeries);
    }

    public void populateStackedBarChartWarehouse() {
        // Clear existing data
        stackedBarChartRegionStock.getData().clear();
    
        // Initialize series for the chart
        XYChart.Series<String, Integer> stockSeries = new XYChart.Series<>();
        stockSeries.setName("Current Stock");
        XYChart.Series<String, Integer> capacitySeries = new XYChart.Series<>();
        capacitySeries.setName("Capacity");
    
        // Initialize variables to hold aggregated data
        Map<String, Integer> totalStockByCategory = new HashMap<>();
        Map<String, Integer> totalCapacityByCategory = new HashMap<>();
    
        // Aggregate data by category
        for (Warehouse warehouse : warehouseRegistry.getWarehouseRegistry()) {
            String addressCategory = warehouse.getAddress(); // Assume getAddress() returns "North", "South", or "Middle"
            Integer stock = warehouse.getCurrentStock();
            Integer capacity = warehouse.getCapacity();
    
            // Aggregate stock
            totalStockByCategory.merge(addressCategory, stock, Integer::sum);
            // Aggregate capacity
            totalCapacityByCategory.merge(addressCategory, capacity, Integer::sum);
        }
    
        // Populate series with aggregated data
        for (String category : totalStockByCategory.keySet()) {
            Integer stock = totalStockByCategory.get(category);
            Integer capacity = totalCapacityByCategory.get(category);
            Integer availableCapacity = capacity - stock;
    
            stockSeries.getData().add(new XYChart.Data<>(category, stock));
            capacitySeries.getData().add(new XYChart.Data<>(category, availableCapacity));
        }
    
        // Add series to chart
        stackedBarChartRegionStock.getData().addAll(stockSeries, capacitySeries);
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

    public void populatePieCharts() {
        populatePieChartTotalCapacity();
        populateBarChart();
        populateStackedBarChartWarehouse();
    }

}
