package apiaryanalysis;

import apiaryanalysis.entities.Apiary;
import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.repositories.ApiaryDataRepositoryImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ApiaryDetailWindowController implements Initializable {

    private final int apiaryId;

    private final ApiaryDataRepository apiaryDataRepository;

    @FXML
    private Label labelName;

    public ApiaryDetailWindowController(int apiaryId) {
        this.apiaryId = apiaryId;
        this.apiaryDataRepository = new ApiaryDataRepositoryImpl("database/apiary-analysis.sqlite");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Apiary apiary = this.apiaryDataRepository.getApiary(apiaryId);
        this.labelName.setText(apiary.getName());
    }
}
