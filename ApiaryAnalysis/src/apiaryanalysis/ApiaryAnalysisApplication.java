/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiaryanalysis;

import apiaryanalysis.ioc.ApiaryAnalysisModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

        Injector injector = Guice.createInjector(new ApiaryAnalysisModule());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ApiaryListWindow.fxml"));
        loader.setControllerFactory(instantiatedClass -> {
            return injector.getInstance(instantiatedClass);
        });

        Scene scene = new Scene(ROOT, 800, 600);

        Parent apiaryListWindow = loader.load();

        ROOT.setCenter(apiaryListWindow);

        stage.setTitle("Apiary analysis");
        stage.setScene(scene);
        stage.show();
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
