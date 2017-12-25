package apiaryanalysis.services;

import apiaryanalysis.dtos.ApiaryDetailDto;
import apiaryanalysis.entities.Apiary;
import java.util.List;

public interface ApiaryService {

    ApiaryDetailDto getApiaryDetail(int apiaryId);

    public List<Apiary> getApiaries();

    public void saveApiary(Apiary apiary);

    public void updateApiary(Apiary apiary);
}
