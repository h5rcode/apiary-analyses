package apiaryanalysis.controllers;

import apiaryanalysis.dtos.ApiaryDetailDto;
import apiaryanalysis.dtos.ApiaryDetailSampleDto;
import apiaryanalysis.entities.Apiary;
import apiaryanalysis.services.ApiaryService;
import apiaryanalysis.session.SessionManager;
import com.google.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ApiaryDetailWindowController implements Initializable {

    private final ApiaryService apiaryService;
    private final SessionManager sessionManager;

    private ApiaryDetailDto apiary;

    @FXML
    private TableView<ApiaryDetailSampleDto> tableView;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldOrderNumber;

    @FXML
    private TextField textFieldFileNumber;

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

        this.loadApiary(apiaryId);
    }

    private void loadApiary(Integer apiaryId) {
        this.apiary = this.apiaryService.getApiaryDetail(apiaryId);

        this.textFieldName.setText(this.apiary.name);
        this.textFieldOrderNumber.setText(String.valueOf(this.apiary.orderNumber));
        this.textFieldFileNumber.setText(this.apiary.fileNumber);

        ObservableList<ApiaryDetailSampleDto> items = tableView.getItems();
        for (ApiaryDetailSampleDto sample : this.apiary.samples) {
            items.add(sample);
        }
    }

    @FXML
    private void addSample(MouseEvent mouseEvent) {
        // TODO
    }

    @FXML
    private void saveApiary(MouseEvent mouseEvent) {
        Apiary apiary = new Apiary();
        apiary.setId(this.apiary.id);
        apiary.setName(this.textFieldName.getText());
        apiary.setOrderNumber(Integer.valueOf(this.textFieldOrderNumber.getText()));
        apiary.setFileNumber(this.textFieldFileNumber.getText());

        this.apiaryService.updateApiary(apiary);

        this.loadApiary(this.apiary.id);
    }
}
