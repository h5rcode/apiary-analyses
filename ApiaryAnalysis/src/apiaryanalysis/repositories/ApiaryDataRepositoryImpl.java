package apiaryanalysis.repositories;

import apiaryanalysis.entities.Apiary;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class ApiaryDataRepositoryImpl implements ApiaryDataRepository {

    private final ConnectionSource connectionSource;
    private final Dao<Apiary, Integer> apiaryDao;

    public ApiaryDataRepositoryImpl(String filename) {
        try {
            this.connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + filename);
            apiaryDao = DaoManager.createDao(connectionSource, Apiary.class);
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
}
