package apiaryanalysis.controllers;

import apiaryanalysis.dialogs.dtos.AddApiaryDialogResult;
import apiaryanalysis.entities.Apiary;
import apiaryanalysis.mediation.ApplicationMediator;
import apiaryanalysis.services.ApiaryService;
import com.google.inject.Inject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ApiaryListWindowController implements Initializable {

    @FXML
    private TableView<Apiary> tableView;

    public final ApiaryService apiaryService;

    public final ApplicationMediator applicationMediator;

    @Inject
    public ApiaryListWindowController(ApiaryService apiaryService, ApplicationMediator applicationMediator) {
        this.apiaryService = apiaryService;
        this.applicationMediator = applicationMediator;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                Apiary apiary = this.tableView.getSelectionModel().getSelectedItem();
                if (apiary != null) {
                    this.applicationMediator.displayApiaryDetail(apiary.getId());
                }
            }
        });

        loadApiaries();
    }

    @FXML
    private void addApiary(MouseEvent event) {
        AddApiaryDialogResult result = this.applicationMediator.displayAddApiaryDialog();

        if (result.isSuccess()) {
            loadApiaries();
        } else {
        }
    }

    private void loadApiaries() {
        List<Apiary> apiaries = this.apiaryService.getApiaries();

        ObservableList<Apiary> items = this.tableView.getItems();
        items.clear();

        for (Apiary apiary : apiaries) {
            items.add(apiary);
        }
    }
}
