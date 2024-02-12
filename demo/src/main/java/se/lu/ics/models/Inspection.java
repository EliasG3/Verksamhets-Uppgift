package se.lu.ics.models;

import se.lu.ics.models.Warehouse;

public class Inspection {
    private Warehouse warehouse;
    private String date;
    private String responsible;
    private String result;
    private int inspectionId;

    public Inspection(Warehouse warehouse,String date,String responsible,String result, int inspectionId){
        this.warehouse = warehouse;
        this.date = date;
        this.responsible = responsible; 
        this.result = result;
        this.inspectionId = inspectionId;
    }

    public Warehouse getWarehouse(){
        return warehouse;
    }

    public String getDate(){
        return date; 
    }

    public String getResponsible(){
        return responsible;
    }

    public String getResult(){
        return result;
    }

    public int getInspectionId(){
        return inspectionId;
    }


    public void setWarehouse(Warehouse warehouse){
        this.warehouse = warehouse; 
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setResponsible(String responsible){
        this.responsible = responsible;
    }

    public void setResult(String result){
        this.result = result; 
    }

    public void setInspectionId(int inspectionId){
        this.inspectionId = inspectionId;
    }
    
}
