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

    public void addWarehouse(Warehouse warehouse){
        this.warehouseRegistry.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse){
        this.warehouseRegistry.remove(warehouse);
    }

    public Warehouse getWarehouse(Warehouse warehouseName){
        for(Warehouse warehouse : this.warehouseRegistry){
            if(warehouse.equals(warehouseName)){
                return warehouse;
            }
        }
        return null;
    }

}
