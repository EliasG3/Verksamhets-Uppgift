package se.lu.ics.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShipmentLogRegistry {
    
    private ObservableList<ShipmentLog> shipmentLogRegistry;

    public ShipmentLogRegistry(){
        this.shipmentLogRegistry = FXCollections.observableArrayList();
    }

    public ObservableList<ShipmentLog> getShipmentLogRegistry(){
        return FXCollections.unmodifiableObservableList(this.shipmentLogRegistry);
    }

    public void addShipmentLog(ShipmentLog shipmentLog){
        this.shipmentLogRegistry.add(shipmentLog);
    }

    public void removeShipmentLog(ShipmentLog shipmentLog){
        this.shipmentLogRegistry.remove(shipmentLog);
    }

    public ShipmentLog getShipmentLog(ShipmentLog shipmentLogId){
        for(ShipmentLog shipmentLog : this.shipmentLogRegistry){
            if(shipmentLog.equals(shipmentLogId)){
                return shipmentLog;
            }
        }
        return null;
    }

    //method that gets the last location of the shipment
    public String getLastLocation(Shipment shipment){
        for(ShipmentLog shipmentLog : this.shipmentLogRegistry){
            if(shipmentLog.getShipment().equals(shipment)){
                return shipmentLog.getWarehouse().getName();
            }
        }
        return null;
    }

    public Warehouse getWarehouse(Shipment shipment){
        for(ShipmentLog shipmentLog : this.shipmentLogRegistry){
            if(shipmentLog.getShipment().equals(shipment)){
                return shipmentLog.getWarehouse();
            }
        }
        return null;
    }
    
}
