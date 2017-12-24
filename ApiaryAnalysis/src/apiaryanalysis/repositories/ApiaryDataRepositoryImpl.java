package apiaryanalysis.repositories;

import apiaryanalysis.entities.Apiary;
import apiaryanalysis.entities.Sample;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class ApiaryDataRepositoryImpl implements ApiaryDataRepository {

    private final ConnectionSource connectionSource;
    private final Dao<Apiary, Integer> apiaryDao;
    private final Dao<Sample, Integer> sampleDao;

    public ApiaryDataRepositoryImpl(String filename) {
        try {
            this.connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + filename);
            this.apiaryDao = DaoManager.createDao(connectionSource, Apiary.class);
            this.sampleDao = DaoManager.createDao(connectionSource, Sample.class);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Apiary> getApiaries() {
        try {
            return this.apiaryDao.queryForAll();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Apiary getApiary(int id) {
        try {
            return this.apiaryDao.queryForId(id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Sample> getSamplesByApiary(int apiaryId) {
        try {
            return this.sampleDao.queryForEq("rucherId", apiaryId);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
