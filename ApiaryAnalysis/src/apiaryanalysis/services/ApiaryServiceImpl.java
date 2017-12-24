package apiaryanalysis.services;

import apiaryanalysis.dtos.ApiaryDetailDto;
import apiaryanalysis.dtos.ApiaryDetailSampleDto;
import apiaryanalysis.entities.Apiary;
import apiaryanalysis.entities.Sample;
import apiaryanalysis.repositories.ApiaryDataRepository;
import com.j256.ormlite.dao.CloseableIterator;
import java.io.IOException;
import java.sql.SQLException;
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
        List<ApiaryDetailSampleDto> sampleDtos = new ArrayList<>();

        CloseableIterator<Sample> closeableIterator = apiary.samples.closeableIterator();

        try {
            while (closeableIterator.hasNext()) {
                Sample sample;
                sample = closeableIterator.current();

                ApiaryDetailSampleDto sampleDto = new ApiaryDetailSampleDto(sample);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                closeableIterator.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        return new ApiaryDetailDto(apiary, sampleDtos);
    }
}
