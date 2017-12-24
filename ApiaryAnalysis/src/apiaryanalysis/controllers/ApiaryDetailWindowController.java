package apiaryanalysis.controllers;

import apiaryanalysis.dtos.ApiaryDetailDto;
import apiaryanalysis.entities.Apiary;
import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.services.ApiaryService;
import apiaryanalysis.session.SessionManager;
import com.google.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ApiaryDetailWindowController implements Initializable {

    private final ApiaryService apiaryService;
    private final SessionManager sessionManager;

    @FXML
    private Label labelName;

    @Inject
    public ApiaryDetailWindowController(ApiaryService apiaryService, SessionManager sessionManager) {
        this.apiaryService = apiaryService;
        this.sessionManager = sessionManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Integer apiaryId = sessionManager.getCurrentApiaryId();

        if (apiaryId == null) {
            throw new RuntimeException("Could not find current apiary id in the session.");
        }

        ApiaryDetailDto apiary = this.apiaryService.getApiaryDetail(apiaryId);
        labelName.setText(apiary.name);
    }
}
