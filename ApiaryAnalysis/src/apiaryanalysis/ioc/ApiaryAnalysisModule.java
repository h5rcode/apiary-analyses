package apiaryanalysis.ioc;

import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.repositories.ApiaryDataRepositoryImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class ApiaryAnalysisModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    public ApiaryDataRepository providerApiaryDataRepository() {
        return new ApiaryDataRepositoryImpl("database/apiary-analysis.sqlite");
    }
}
