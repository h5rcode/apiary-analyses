package apiaryanalysis.mediation;

import apiaryanalysis.ApiaryAnalysisApplication;
import apiaryanalysis.dialogs.dtos.AddApiaryDialogResult;
import apiaryanalysis.ioc.ApiaryAnalysisInjector;
import apiaryanalysis.session.SessionManager;
import com.google.inject.Injector;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ApplicationMediatorImpl implements ApplicationMediator {

    private final Injector injector;
    private final SessionManager sessionManager;

    public ApplicationMediatorImpl(SessionManager sessionManager) {
        this.injector = ApiaryAnalysisInjector.getInjector();
        this.sessionManager = sessionManager;
    }

    @Override
    public void displayApiaries() {
        changeController("/apiaryanalysis/views/ApiaryListWindow.fxml");
    }

    @Override
    public void displayApiaryDetail(int apiaryId) {
        this.sessionManager.setCurrentApiaryId(apiaryId);
        changeController("/apiaryanalysis/views/ApiaryDetailWindow.fxml");
    }

    @Override
    public AddApiaryDialogResult displayAddApiaryDialog() {
        openDialog("/apiaryanalysis/views/DialogAddApiary.fxml");
        return new AddApiaryDialogResult(false);
    }

    private void changeController(final String resourceName) {
        Node node = loadResource(resourceName);

        BorderPane borderPane = ApiaryAnalysisApplication.getRoot();
        borderPane.setCenter(node);
    }

    private void openDialog(final String resourceName) {
        Parent parent = loadResource(resourceName);

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);

        Scene scene = new Scene(parent);
        dialogStage.setScene(scene);

        dialogStage.showAndWait();
    }

    private <T> T loadResource(final String resourceName) throws RuntimeException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
        loader.setControllerFactory(instantiatedClass -> {
            return injector.getInstance(instantiatedClass);
        });
        T object;
        try {
            object = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return object;
    }
}
