package com.main.App.Build.App;

import com.main.App.Build.BaseModel.GameBase;
import com.main.App.Build.Interface.GameInterface;

public class Game extends GameBase implements GameInterface {

    public Game() {
        super(new GameInput());
    }

    public void gameStarter() {
        getGameInput().inputInit();
        setGameComputer(getGameInput().getGameComputer());
        setGameSetting(getGameInput().getGameSetting());
        placePlacement();
    }

    private void placePlacement() {

        while (true) {
            getGameInput().getGameMapDisplay().gameMapDisplay();
            String placement = getGameInput().askForPlacement();
            if (getGameInput().checkPlacementInputIsValid(placement)) {
                int firstPlacement = getGameInput().getFirstPlacement();
                int secondPlacement = getGameInput().getSecondPlacement();
                getGameSetting().getOwnPlacement().add(placement);
                getGameInput().getGameMapDisplay().getGameMap()[firstPlacement][secondPlacement]
                        .setMapIcon(getGameInput().getGameSetting().getFirstPlayerIcon());
                getGameComputer().randomPlacement();
            } else {
                System.out.println(getGameInput().getCustomErrorMessage());
            }
            //TODO: implement GameRule class
        }
    }
}
