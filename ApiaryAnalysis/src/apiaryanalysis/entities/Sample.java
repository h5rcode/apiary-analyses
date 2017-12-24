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
}
