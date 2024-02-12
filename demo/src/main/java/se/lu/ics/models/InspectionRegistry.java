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
}
