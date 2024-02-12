package se.lu.ics.models;

import se.lu.ics.models.Warehouse;
import se.lu.ics.models.Inspection;

public class Shipment {

    private Warehouse responsiblWarehouse;
    private Inspection inspection;
    private String type;
    private int shipmentId; 
    private int daysStored;

    public Shipment(Warehouse responsiblWarehouse, Inspection inspection, String type, int shipmentId, int daysStored) {
        this.responsiblWarehouse = responsiblWarehouse;
        this.inspection = inspection;
        this.type = type;
        this.shipmentId = shipmentId;
        this.daysStored = daysStored;
    }

    public Warehouse getResponsiblWarehouse() {
        return responsiblWarehouse;
    }

    public Inspection getInspection() {
        return inspection;
    }

    public String getType() {
        return type;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public int getDaysStored(){
        return daysStored;
    }

    public void setDaysStored(int daysStored){
        this.daysStored = daysStored;
    }

    public void setResponsiblWarehouse(Warehouse responsiblWarehouse) {
        this.responsiblWarehouse = responsiblWarehouse;
    }

    public void setInspection(Inspection inspection) {
        this.inspection = inspection;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }
    
}
