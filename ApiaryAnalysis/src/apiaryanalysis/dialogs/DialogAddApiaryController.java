package apiaryanalysis.dialogs;

import apiaryanalysis.entities.Apiary;
import apiaryanalysis.services.ApiaryService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.inject.Inject;

public class DialogAddApiaryController implements Initializable {

    private final ApiaryService apiaryService;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldOrderNumber;

    @FXML
    private TextField textFieldFileNumber;

    @Inject
    public DialogAddApiaryController(ApiaryService apiaryService) {
        this.apiaryService = apiaryService;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveApiary(MouseEvent mouseEvent) {
        String name = this.textFieldName.getText();
        String fileNumber = this.textFieldFileNumber.getText();
        String orderNumber = this.textFieldOrderNumber.getText();

        Apiary apiary = new Apiary();
        apiary.setName(name);
        apiary.setFileNumber(fileNumber);
        apiary.setOrderNumber(Integer.valueOf(orderNumber));

        this.apiaryService.saveApiary(apiary);
    }
}
