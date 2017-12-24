package apiaryanalysis.services;

import apiaryanalysis.dtos.ApiaryDetailDto;

public interface ApiaryService {

    ApiaryDetailDto getApiaryDetail(int apiaryId);
}
