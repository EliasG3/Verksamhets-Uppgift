package se.lu.ics.models;

import se.lu.ics.models.Warehouse;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import se.lu.ics.models.Inspection;

public class Shipment {
    private Inspection inspection;
    private String type;
    private int shipmentId; 
    private int daysStored;
    private ObservableList<ShipmentLog> shipmentLog;

    public Shipment( Inspection inspection, String type, int shipmentId, int daysStored) {
        this.inspection = inspection;
        this.type = type;
        this.shipmentId = shipmentId;
        this.daysStored = daysStored;
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

    public ObservableList<ShipmentLog> getShipmentLog() {
        return shipmentLog;
    }

    public void setDaysStored(int daysStored){
        this.daysStored = daysStored;
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

    public void addShipmentLog(ShipmentLog shipmentLog){
        this.shipmentLog.add(shipmentLog);
    }


}
