/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiaryanalysis;

import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.entities.Apiary;
import com.google.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ApiaryListWindowController implements Initializable {

    @FXML
    private TableView<Apiary> tableView;

    public final ApiaryDataRepository apiaryDataRepository;

    @Inject
    public ApiaryListWindowController(ApiaryDataRepository apiaryDataRepository) {
        this.apiaryDataRepository = apiaryDataRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                Apiary apiary = this.tableView.getSelectionModel().getSelectedItem();

                Node node;
                try {
                    node = FXMLLoader.load(getClass().getResource("ApiaryDetailWindow.fxml"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                BorderPane borderPane = ApiaryAnalysisApplication.getRoot();
                borderPane.setCenter(node);
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
