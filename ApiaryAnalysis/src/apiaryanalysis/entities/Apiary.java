package apiaryanalysis.entities;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Rucher")
public class Apiary {

    @DatabaseField(id = true)
    private Integer id;

    @DatabaseField(columnName = "Nom", canBeNull = false)
    private String name;

    @DatabaseField(columnName = "NumeroOrdre", canBeNull = false)
    private Integer orderNumber;

    @DatabaseField(columnName = "NumeroDossier", canBeNull = false)
    private String fileNumber;

    @ForeignCollectionField
    public ForeignCollection<Sample> samples;

    public Apiary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }
}
