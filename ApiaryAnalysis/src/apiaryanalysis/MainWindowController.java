/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiaryanalysis;

import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.repositories.ApiaryDataRepositoryImpl;
import apiaryanalysis.entities.Apiary;
import apiaryanalysis.entities.Sample;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class MainWindowController implements Initializable {

    @FXML
    private TableView<Apiary> tableView;

    private ApiaryDataRepository apiaryDataRepository;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.apiaryDataRepository = new ApiaryDataRepositoryImpl("database/apiary-analysis.sqlite");

        this.tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                Apiary apiary = tableView.getSelectionModel().getSelectedItem();

                List<Sample> samplesByApiary = this.apiaryDataRepository.getSamplesByApiary(apiary.getId());

                int a = samplesByApiary.size();
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
