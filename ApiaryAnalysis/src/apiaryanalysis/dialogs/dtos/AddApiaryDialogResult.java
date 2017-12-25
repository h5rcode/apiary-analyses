package apiaryanalysis.dialogs.dtos;

public class AddApiaryDialogResult {

    private final boolean success;

    public AddApiaryDialogResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
