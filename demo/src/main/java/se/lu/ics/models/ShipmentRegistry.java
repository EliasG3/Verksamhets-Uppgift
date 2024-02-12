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
    
}
