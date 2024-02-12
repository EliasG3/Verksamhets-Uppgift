package se.lu.ics.models;



public class Warehouse {
    private String name;
    private String address;
    private int capacity;
    private int currentStock;
    private String lastInspectionDate;

    public Warehouse(String name, String address, int capacity, int currentStock, String lastInspectionDate) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.currentStock = currentStock;
        this.lastInspectionDate = lastInspectionDate;
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

    //--------------------------------------------------------------------------------

    public void receive(int amount) {
        this.currentStock += amount;
    }

    public void ship(int amount) {
        this.currentStock -= amount;
    }

}
