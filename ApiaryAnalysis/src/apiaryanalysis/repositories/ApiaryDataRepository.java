package apiaryanalysis.repositories;

import apiaryanalysis.entities.Apiary;
import apiaryanalysis.entities.Sample;
import java.util.List;

public interface ApiaryDataRepository {

    List<Apiary> getApiaries();

    Apiary getApiary(int id);

    List<Sample> getSamplesByApiary(int apiaryId);

    public void saveApiary(Apiary apiary);

    public void updateApiary(Apiary apiary);
}
