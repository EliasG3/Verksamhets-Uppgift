package se.lu.ics.models;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Warehouse {

    private String name;
    private String address;
    private int capacity;
    private int currentStock;
    private String lastInspectionDate;

    private ObservableList<Shipment> shipments;

    public Warehouse(String name, String address, int capacity, int currentStock, String lastInspectionDate) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.currentStock = currentStock;
        this.lastInspectionDate = lastInspectionDate;
        this.shipments = FXCollections.observableArrayList();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public String getLastInspectionDate() {
        return lastInspectionDate;
    }

    public ObservableList<Shipment> getShipments() {
        return shipments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public void setLastInspectionDate(String lastInspectionDate) {
        this.lastInspectionDate = lastInspectionDate;
    }

    public void addShipment(Shipment shipment) {
        this.shipments.add(shipment);
    }

    //--------------------------------------------------------------------------------

    public void receive(int amount) {
        this.currentStock += amount;
    }

    public void ship(int amount) {
        this.currentStock -= amount;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
