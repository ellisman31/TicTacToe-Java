package com.main.App.Build.App;

import com.main.App.Build.BaseModel.GameBase;
import com.main.App.Build.Interface.GameComputerInterface;

import java.util.Random;

public class GameComputer extends GameBase implements GameComputerInterface {

    private final Random random = new Random();

    private String placement;

    public GameComputer(GameSetting gameSetting, GameMapDisplay gameMap, GameInput gameInput) {
        super(gameSetting, gameMap.getGameMap(), gameInput, gameSetting.getOwnPlacement());
    }

    public void randomPlacement() {
        randomPlacementValues();
        if (getGameInput().checkPlacementInputIsValid(this.placement)) {
            super.getOwnPlacement().add(this.placement);
            getGameMap()[getGameInput().getFirstPlacement()][getGameInput().getSecondPlacement()]
                    .setMapIcon(getGameSetting().getSecondPlayerIcon());
            System.out.println("The computer placed on" + " " + this.placement.toUpperCase());
        }
    }

    private void randomPlacementValues() {

        int randomPlacementValue;
        char randomPlacementLetter;

        while (true) {

            randomPlacementValue = random.nextInt(getGameSetting().getyMapValue()) + 1;
            randomPlacementLetter = (char) (97 + random.nextInt(getGameSetting().getxMapValue()));

            if (randomPlacementValue <= getGameSetting().getyMapValue()) {
                this.placement = randomPlacementLetter + "" + randomPlacementValue;
                if (!getOwnPlacement().contains(placement) && !getOwnPlacement().contains(this.placement)) {
                    break;
                }
            }
        }
    }

}
