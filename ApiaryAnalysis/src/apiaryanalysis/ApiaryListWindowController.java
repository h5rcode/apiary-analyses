/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiaryanalysis;

import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.repositories.ApiaryDataRepositoryImpl;
import apiaryanalysis.entities.Apiary;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private final ApiaryDataRepository apiaryDataRepository;

    public ApiaryListWindowController() {
        this.apiaryDataRepository = new ApiaryDataRepositoryImpl("database/apiary-analysis.sqlite");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                Apiary apiary = this.tableView.getSelectionModel().getSelectedItem();

                Node node;
                try {
                    ApiaryDetailWindowController controller = new ApiaryDetailWindowController(apiary.getId());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ApiaryDetailWindow.fxml"));
                    loader.setController(controller);
                    node = loader.load();
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
