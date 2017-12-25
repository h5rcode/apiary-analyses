package apiaryanalysis.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Echantillon")
public class Sample {

    @DatabaseField(id = true)
    private int id;

    @DatabaseField(columnName = "Identifiant")
    private String identifier;

    @DatabaseField(columnName = "MatriceCode")
    private String matrixCode;

    @DatabaseField(columnName = "RucherId", foreign = true)
    private Apiary apiary;

    @DatabaseField(columnName = "organismeIdPreleveur", foreign = true)
    private Organization samplerOrganization;

    @DatabaseField(columnName = "organismeIdFinanceur", foreign = true)
    private Organization financerOrganization;

    @DatabaseField(columnName = "matriceCode", foreign = true)
    private Matrix matrix;

    public Sample() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Apiary getApiary() {
        return apiary;
    }

    public void setApiary(Apiary apiary) {
        this.apiary = apiary;
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

    public Organization getSamplerOrganization() {
        return samplerOrganization;
    }

    public void setSamplerOrganization(Organization organizationIdSampler) {
        this.samplerOrganization = organizationIdSampler;
    }

    public Organization getFinancerOrganization() {
        return financerOrganization;
    }

    public void setFinancerOrganization(Organization organizationIdFinancer) {
        this.financerOrganization = organizationIdFinancer;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
