package com.main.App.Build.Interface;

public interface GameInputInterface {

    private void setPlacement(int firstPlacement, int secondPlacement) {
    }

    boolean checkPlacementInputIsValid(String placement);

    private boolean sendPlacementChangeEvent(int letterValue, String numberOfPlacement) {
        return false;
    }

    private void setCustomErrorMessage(String customErrorMessage) {
    }

    void inputInit();
}
