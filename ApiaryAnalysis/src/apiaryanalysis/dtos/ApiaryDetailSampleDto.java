package apiaryanalysis.dtos;

import apiaryanalysis.entities.Matrix;
import apiaryanalysis.entities.Organization;
import apiaryanalysis.entities.Sample;

public class ApiaryDetailSampleDto {

    private int id;

    private String identifier;

    private String matrixCode;

    private String matrixLabel;

    private int samplerOrganizationId;

    private String samplerOrganizationName;

    private int financerOrganizationId;

    private String financerOrganizationName;

    public ApiaryDetailSampleDto(Sample sample) {
        Organization organizationSampler = sample.getSamplerOrganization();
        Organization organizationFinancer = sample.getFinancerOrganization();
        Matrix matrix = sample.getMatrix();

        this.id = sample.getId();
        this.identifier = sample.getIdentifier();
        this.financerOrganizationId = organizationFinancer.getId();
        this.samplerOrganizationId = organizationSampler.getId();
        this.financerOrganizationName = organizationFinancer.getName();
        this.samplerOrganizationName = organizationSampler.getName();
        this.matrixCode = matrix.getCode();
        this.matrixLabel = matrix.getLabel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMatrixCode() {
        return matrixCode;
    }

    public void setMatrixCode(String matrixCode) {
        this.matrixCode = matrixCode;
    }

    public String getMatrixLabel() {
        return matrixLabel;
    }

    public void setMatrixLabel(String matrixLabel) {
        this.matrixLabel = matrixLabel;
    }

    public int getSamplerOrganizationId() {
        return samplerOrganizationId;
    }

    public void setSamplerOrganizationId(int samplerOrganizationId) {
        this.samplerOrganizationId = samplerOrganizationId;
    }

    public String getSamplerOrganizationName() {
        return samplerOrganizationName;
    }

    public void setSamplerOrganizationName(String samplerOrganizationName) {
        this.samplerOrganizationName = samplerOrganizationName;
    }

    public int getFinancerOrganizationId() {
        return financerOrganizationId;
    }

    public void setFinancerOrganizationId(int financerOrganizationId) {
        this.financerOrganizationId = financerOrganizationId;
    }

    public String getFinancerOrganizationName() {
        return financerOrganizationName;
    }

    public void setFinancerOrganizationName(String financerOrganizationName) {
        this.financerOrganizationName = financerOrganizationName;
    }
}
