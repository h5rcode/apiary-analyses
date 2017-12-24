package apiaryanalysis.entities;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Rucher")
public class Apiary {

    @DatabaseField(id = true)
    private int id;

    @DatabaseField(columnName = "Nom")
    private String name;

    @DatabaseField(columnName = "NumeroOrdre")
    private int orderNumber;

    @DatabaseField(columnName = "NumeroDossier")
    private String fileNumber;

    @ForeignCollectionField
    public ForeignCollection<Sample> samples;

    public Apiary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }
}
