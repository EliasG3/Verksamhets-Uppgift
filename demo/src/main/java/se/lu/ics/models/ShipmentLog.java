package se.lu.ics.models;

public class ShipmentLog {

    private String date; //Might need a arrival and departure date
    private Warehouse warehouse;
    private Shipment shipment;

    public ShipmentLog(String date, Warehouse warehouse, Shipment shipment){
        
        this.date = date;
        this.warehouse = warehouse;
        this.shipment = shipment;
    }

    public String getDate(){
        return date;
    }

    public Warehouse getWarehouse(){
        return warehouse;
    }

    public Shipment getShipment(){
        return shipment;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setWarehouse(Warehouse warehouse){
        this.warehouse = warehouse;
    }

    public void setShipment(Shipment shipment){
        this.shipment = shipment;
    }

}
