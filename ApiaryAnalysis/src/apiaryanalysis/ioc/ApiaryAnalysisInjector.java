package apiaryanalysis.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ApiaryAnalysisInjector {

    private static Injector INJECTOR;

    private ApiaryAnalysisInjector() {
    }

    public static synchronized Injector getInjector() {
        if (INJECTOR == null) {
            INJECTOR = Guice.createInjector(new ApiaryAnalysisModule());
        }

        return INJECTOR;
    }
}
