/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiaryanalysis;

import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.repositories.ApiaryDataRepositoryImpl;
import apiaryanalysis.entities.Apiary;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainWindowController implements Initializable {

    @FXML
    private Label label;

    private ApiaryDataRepository apiaryDataRepository;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");

        List<Apiary> apiaries = this.apiaryDataRepository.getApiaries();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.apiaryDataRepository = new ApiaryDataRepositoryImpl("D:/Francois/NetBeansProjects/apiary-analysis/ApiaryAnalysis/database/apiary-analysis.sqlite");
    }
}
