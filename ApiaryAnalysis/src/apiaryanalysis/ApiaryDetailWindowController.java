package apiaryanalysis;

import apiaryanalysis.entities.Apiary;
import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.session.SessionManager;
import com.google.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ApiaryDetailWindowController implements Initializable {

    private final ApiaryDataRepository apiaryDataRepository;
    private final SessionManager sessionManager;

    @FXML
    private Label labelName;

    @Inject
    public ApiaryDetailWindowController(ApiaryDataRepository apiaryDataRepository, SessionManager sessionManager) {
        this.apiaryDataRepository = apiaryDataRepository;
        this.sessionManager = sessionManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Integer apiaryId = sessionManager.getCurrentApiaryId();

        if (apiaryId == null) {
            throw new RuntimeException("Could not find current apiary id in the session.");
        }

        Apiary apiary = apiaryDataRepository.getApiary(apiaryId);

        labelName.setText(apiary.getName());
    }
}
