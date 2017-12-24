package apiaryanalysis;

import apiaryanalysis.ioc.ApiaryAnalysisInjector;
import apiaryanalysis.mediation.ApplicationMediator;
import com.google.inject.Injector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ApiaryAnalysisApplication extends Application {

    private final static BorderPane ROOT = new BorderPane();

    public static BorderPane getRoot() {
        return ROOT;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(ApiaryAnalysisApplication::handleException);

        Injector injector = ApiaryAnalysisInjector.getInjector();

        Scene scene = new Scene(ROOT, 800, 600);
        stage.setTitle("Apiary analysis");
        stage.setScene(scene);
        stage.show();

        ApplicationMediator applicationMediator = injector.getInstance(ApplicationMediator.class);
        applicationMediator.displayApiaries();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void handleException(Thread t, Throwable e) {
        Logger.getLogger(ApiaryAnalysisApplication.class.getName()).log(Level.SEVERE, null, e);
    }
}
