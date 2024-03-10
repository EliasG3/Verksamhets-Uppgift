package se.lu.ics.models;

public class ShipmentLog {

    private String date; //Might need a arrival and departure date
    private Warehouse warehouse;
    private Shipment shipment;
    private int shipmentLogId;
    private int daysStored;

    public ShipmentLog(String date, Warehouse warehouse, Shipment shipment, int shipmentLogId, int daysStored){
        
        this.date = date;
        this.warehouse = warehouse;
        this.shipment = shipment;
        this.shipmentLogId = shipmentLogId;
        this.daysStored = daysStored;
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

    public int getShipmentLogId(){
        return shipmentLogId;
    }

    public int getDaysStored(){
        return daysStored;
    }

    public void setDaysStored(int daysStored){
        this.daysStored = daysStored;
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

    public void setShipmentLogId(int shipmentLogId){
        this.shipmentLogId = shipmentLogId;
    }

}
