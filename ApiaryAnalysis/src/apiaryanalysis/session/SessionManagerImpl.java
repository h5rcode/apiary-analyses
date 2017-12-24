package apiaryanalysis.session;

public class SessionManagerImpl implements SessionManager {

    private Integer currentApiaryId;

    @Override
    public Integer getCurrentApiaryId() {
        return currentApiaryId;
    }

    @Override
    public void setCurrentApiaryId(int apiaryId) {
        this.currentApiaryId = apiaryId;
    }

}
