package se.lu.ics.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class ShipmentRegistry {

    private ObservableList<Shipment> shipmentRegistry;

    public ShipmentRegistry(){
        this.shipmentRegistry = FXCollections.observableArrayList();
    }

    public ObservableList<Shipment> getShipmentRegistry(){
        return FXCollections.unmodifiableObservableList(this.shipmentRegistry);
    }

    public void addShipment(Shipment shipment){
        this.shipmentRegistry.add(shipment);
    }

    public void removeShipment(Shipment shipment){
        this.shipmentRegistry.remove(shipment);
    }

    public Shipment getShipment(int shipmentId){
        for(Shipment shipment : this.shipmentRegistry){
            if(shipment.getShipmentId() == shipmentId){
                return shipment;
            }
        }
        return null;
    }


    // method that gets the current location using shipmentlog
    public Warehouse getCurrentLocation(Shipment shipment){
        ObservableList<ShipmentLog> shipmentLog = shipment.getShipmentLog();
        return shipmentLog.get(shipmentLog.size()-1).getWarehouse();
    }

}
