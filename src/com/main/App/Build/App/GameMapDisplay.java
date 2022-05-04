package com.main.App.Build.App;

import com.main.App.Build.BaseModel.GameBase;
import com.main.App.Build.Interface.GameMapDisplayInterface;

public class GameMapDisplay extends GameBase implements GameMapDisplayInterface {

    private final int gameMapLength;

    public GameMapDisplay(GameMap[][] gameMap, GameSetting gameSetting) {
        super(gameSetting, gameMap);
        this.gameMapLength = getGameMap().length;
        gameMapInit();
    }

    public void gameMapDisplay() {

        for (int row = 0; row < gameMapLength; row++) {
            char alphabet = (char) (65 + row);
            System.out.print(alphabet + " ");

            for (int col = 0; col < getGameMap()[row].length; col++) {
                System.out.print(getGameMap()[row][col].getMapIcon());
            }

            System.out.println(" ");

            if (row == gameMapLength-1) {
                for (int k = 0; k < getGameSetting().getyMapValue(); k++) {
                    System.out.print("  " + (k+1));
                }
            }
        }
    }

    private void gameMapInit() {
        for (int row = 0; row < gameMapLength; row++) {
            for (int col = 0; col < getGameMap()[row].length; col++) {
                getGameMap()[row][col] = new GameMap();
            }
        }
    }
}
