package se.lu.ics.models;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class Shipment {
    
    private String type;
    private int shipmentId;
    private int quantity;
    private int daysStored;

    public Shipment( String type, int shipmentId, int quantity, int daysStored) {
       
        this.type = type;
        this.shipmentId = shipmentId;
        this.quantity = quantity;
        this.daysStored = daysStored;
    }
  
    
    public String getType() {
        return type;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDaysStored() {
        return daysStored;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDaysStored(int daysStored) {
        this.daysStored = daysStored;
    }

    @Override
    public String toString() {
        return Integer.toString(this.shipmentId);
    }

}
