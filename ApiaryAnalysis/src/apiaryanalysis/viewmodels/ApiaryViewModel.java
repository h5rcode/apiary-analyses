package apiaryanalysis.viewmodels;

import apiaryanalysis.dtos.ApiaryDetailDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ApiaryViewModel {

    private StringProperty nameProperty = new SimpleStringProperty();

    public ApiaryViewModel() {
    }

    public ApiaryViewModel(ApiaryDetailDto apiary) {
        this.nameProperty.set(apiary.name);
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public void setNameProperty(StringProperty nameProperty) {
        this.nameProperty = nameProperty;
    }
}
