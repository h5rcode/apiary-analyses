package apiaryanalyses.repositories;

import apiaryanalysis.entities.Apiary;
import java.util.List;

public interface ApiaryDataRepository {

    List<Apiary> getApiaries();

    Apiary getApiary(int id);
}
