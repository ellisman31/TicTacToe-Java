package com.main.App.Build.App;

import com.main.App.Build.Interface.GameInterface;

public class Game implements GameInterface {

    private final GameInput gameInput = new GameInput();
    private GameComputer gameComputer;
    private GameSetting gameSetting;

    public void gameStarter() {
        gameInput.inputInit();
        this.gameComputer = gameInput.getGameComputer();
        this.gameSetting = gameInput.getGameSetting();
        placePlacement();
    }

    private void placePlacement() {

        while (true) {
            gameInput.getGameMapDisplay().gameMapDisplay();
            String placement = gameInput.askForPlacement();
            if (gameInput.checkPlacementInputIsValid(placement)) {
                int firstPlacement = gameInput.getFirstPlacement();
                int secondPlacement = gameInput.getSecondPlacement();
                gameSetting.getOwnPlacement().add(placement);
                gameInput.getGameMapDisplay().getGameMap()[firstPlacement][secondPlacement].setMapIcon(gameInput.getGameSetting().getFirstPlayerIcon());
                gameComputer.randomPlacement(gameSetting.getOwnPlacement());
            }
            else {
                System.out.println(gameInput.getCustomErrorMessage());
            }
            //TODO: implement GameRule class
        }
    }
}
