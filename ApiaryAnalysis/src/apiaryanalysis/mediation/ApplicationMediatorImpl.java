package apiaryanalysis.mediation;

import apiaryanalysis.ApiaryAnalysisApplication;
import apiaryanalysis.ioc.ApiaryAnalysisInjector;
import apiaryanalysis.session.SessionManager;
import com.google.inject.Injector;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class ApplicationMediatorImpl implements ApplicationMediator {

    private final Injector injector;
    private final SessionManager sessionManager;

    public ApplicationMediatorImpl(SessionManager sessionManager) {
        this.injector = ApiaryAnalysisInjector.getInjector();
        this.sessionManager = sessionManager;
    }

    @Override
    public void displayApiaries() {
        changeController("/apiaryanalysis/ApiaryListWindow.fxml");
    }

    @Override
    public void displayApiaryDetail(int apiaryId) {
        this.sessionManager.setCurrentApiaryId(apiaryId);
        changeController("/apiaryanalysis/ApiaryDetailWindow.fxml");
    }

    private void changeController(final String resourceName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
        loader.setControllerFactory(instantiatedClass -> {
            return injector.getInstance(instantiatedClass);
        });

        Node node;
        try {
            node = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        BorderPane borderPane = ApiaryAnalysisApplication.getRoot();
        borderPane.setCenter(node);
    }
}
