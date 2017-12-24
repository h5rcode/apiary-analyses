package apiaryanalysis.dtos;

import apiaryanalysis.entities.Sample;

public class ApiaryDetailSampleDto {

    public int id;

    public String identifier;

    public String matrixCode;

    public ApiaryDetailSampleDto(Sample sample) {
        this.id = sample.getId();
        this.identifier = sample.getIdentifier();
        this.matrixCode = sample.getMatrixCode();
    }
}
