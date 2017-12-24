package apiaryanalysis;

import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.entities.Apiary;
import apiaryanalysis.mediation.ApplicationMediator;
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

    public final ApiaryDataRepository apiaryDataRepository;

    public final ApplicationMediator applicationMediator;

    @Inject
    public ApiaryListWindowController(ApiaryDataRepository apiaryDataRepository, ApplicationMediator applicationMediator) {
        this.apiaryDataRepository = apiaryDataRepository;
        this.applicationMediator = applicationMediator;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                Apiary apiary = this.tableView.getSelectionModel().getSelectedItem();
                this.applicationMediator.displayApiaryDetail(apiary.getId());
            }
        });

        loadApiaries();
    }

    private void loadApiaries() {
        List<Apiary> apiaries = this.apiaryDataRepository.getApiaries();

        ObservableList<Apiary> items = this.tableView.getItems();

        for (Apiary apiary : apiaries) {
            items.add(apiary);
        }
    }
}
