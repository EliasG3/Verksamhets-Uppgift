package se.lu.ics.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import se.lu.ics.models.Inspection;

public class InspectionRegistry {

    private ObservableList<Inspection> inspectionRegistry;

    public InspectionRegistry(){
        this.inspectionRegistry = FXCollections.observableArrayList();
    }

    public ObservableList<Inspection> getInspectionRegistry(){
        return FXCollections.unmodifiableObservableList(this.inspectionRegistry);
    }

    public void addInspection(Inspection inspection){
        this.inspectionRegistry.add(inspection);
    }

    public void removeInspection(Inspection inspection){
        this.inspectionRegistry.remove(inspection);
    }

    public Inspection getInspection(int inspectionId){
        for(Inspection inspection : this.inspectionRegistry){
            if(inspection.getInspectionId() == inspectionId){
                return inspection;
            }
        }
        return null;
    }
}
