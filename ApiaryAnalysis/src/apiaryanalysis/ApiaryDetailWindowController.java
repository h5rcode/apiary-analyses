package apiaryanalysis;

import apiaryanalysis.entities.Apiary;
import apiaryanalysis.repositories.ApiaryDataRepository;
import com.google.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ApiaryDetailWindowController implements Initializable {

    private final ApiaryDataRepository apiaryDataRepository;

    @FXML
    private Label labelName;

    @Inject
    public ApiaryDetailWindowController(ApiaryDataRepository apiaryDataRepository) {
        this.apiaryDataRepository = apiaryDataRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Do nothing.
    }
}
