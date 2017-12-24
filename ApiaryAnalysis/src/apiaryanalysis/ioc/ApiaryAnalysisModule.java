package apiaryanalysis.ioc;

import apiaryanalysis.mediation.ApplicationMediator;
import apiaryanalysis.mediation.ApplicationMediatorImpl;
import apiaryanalysis.repositories.ApiaryDataRepository;
import apiaryanalysis.repositories.ApiaryDataRepositoryImpl;
import apiaryanalysis.session.SessionManager;
import apiaryanalysis.session.SessionManagerImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class ApiaryAnalysisModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    public ApiaryDataRepository provideApiaryDataRepository() {
        return new ApiaryDataRepositoryImpl("database/apiary-analysis.sqlite");
    }

    @Provides
    @Singleton
    public ApplicationMediator provideApplicationMediator(SessionManager sessionManager) {
        return new ApplicationMediatorImpl(sessionManager);
    }

    @Provides
    @Singleton
    public SessionManager provideSessionManager() {
        return new SessionManagerImpl();
    }
}
