package apiaryanalysis.services;

import apiaryanalysis.dtos.ApiaryDetailDto;
import apiaryanalysis.dtos.ApiaryDetailSampleDto;
import apiaryanalysis.entities.Apiary;
import apiaryanalysis.entities.Sample;
import apiaryanalysis.repositories.ApiaryDataRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ApiaryServiceImpl implements ApiaryService {

    private final ApiaryDataRepository apiaryDataRepository;

    @Inject
    public ApiaryServiceImpl(ApiaryDataRepository apiaryDataRepository) {
        this.apiaryDataRepository = apiaryDataRepository;
    }

    @Override
    public ApiaryDetailDto getApiaryDetail(int apiaryId) {
        Apiary apiary = apiaryDataRepository.getApiary(apiaryId);

        List<Sample> samples = apiaryDataRepository.getSamplesByApiary(apiaryId);

        List<ApiaryDetailSampleDto> sampleDtos = new ArrayList<>();
        for (Sample sample : samples) {
            sampleDtos.add(new ApiaryDetailSampleDto(sample));
        }

        return new ApiaryDetailDto(apiary, sampleDtos);
    }

    @Override
    public List<Apiary> getApiaries() {
        return this.apiaryDataRepository.getApiaries();
    }

    @Override
    public void saveApiary(Apiary apiary) {
        this.apiaryDataRepository.saveApiary(apiary);
    }

    @Override
    public void updateApiary(Apiary apiary) {
        this.apiaryDataRepository.updateApiary(apiary);
    }
}
