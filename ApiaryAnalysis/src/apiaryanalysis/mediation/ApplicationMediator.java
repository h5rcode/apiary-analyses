package apiaryanalysis.mediation;

import apiaryanalysis.dialogs.dtos.AddApiaryDialogResult;

public interface ApplicationMediator {

    public void displayApiaryDetail(int apiaryId);

    public void displayApiaries();

    public AddApiaryDialogResult displayAddApiaryDialog();
}
