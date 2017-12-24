package apiaryanalysis.dtos;

import apiaryanalysis.entities.Apiary;
import java.util.ArrayList;
import java.util.List;

public class ApiaryDetailDto {

    public int id;

    public String name;

    public int orderNumber;

    public String fileNumber;

    public List<ApiaryDetailSampleDto> samples;

    public ApiaryDetailDto(Apiary apiary, List<ApiaryDetailSampleDto> sampleDtos) {
        this.id = apiary.getId();
        this.name = apiary.getName();
        this.orderNumber = apiary.getOrderNumber();
        this.fileNumber = apiary.getFileNumber();
        this.samples = new ArrayList<>(sampleDtos);
    }

}
