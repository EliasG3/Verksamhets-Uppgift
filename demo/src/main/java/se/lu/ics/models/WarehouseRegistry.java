package se.lu.ics.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WarehouseRegistry {

    private ObservableList<Warehouse> warehouseRegistry;

    public WarehouseRegistry(){
        this.warehouseRegistry = FXCollections.observableArrayList();
    }

    public ObservableList<Warehouse> getWarehouseRegistry(){
        return FXCollections.unmodifiableObservableList(this.warehouseRegistry);
    }

    
}
