package com.main.App.Build.App;

import com.main.App.Build.Interface.GameMapDisplayInterface;

public class GameMapDisplay implements GameMapDisplayInterface {

    private final GameMapSetting[][] gameMap;
    private final GameSetting gameSetting;
    private final int gameMapLength;

    public GameMapDisplay(GameMapSetting[][] gameMapSetting, GameSetting gameSetting) {
        this.gameMap = gameMapSetting;
        this.gameSetting = gameSetting;
        this.gameMapLength = this.gameMap.length;
        gameMapInit();
    }

    public void gameMapDisplay() {

        for (int row = 0; row < gameMapLength; row++) {
            char alphabet = (char) (65 + row);
            System.out.print(alphabet + " ");

            for (int col = 0; col < this.gameMap[row].length; col++) {
                System.out.print(this.gameMap[row][col].getMapIcon());
            }

            System.out.println(" ");

            if (row == gameMapLength-1) {
                for (int k = 0; k < gameSetting.getyMapValue(); k++) {
                    System.out.print("  " + (k+1));
                }
            }
        }
    }

    private void gameMapInit() {
        for (int row = 0; row < gameMapLength; row++) {
            for (int col = 0; col < this.gameMap[row].length; col++) {
                this.gameMap[row][col] = new GameMapSetting();
            }
        }
    }

    public GameMapSetting[][] getGameMap() {
        return gameMap;
    }

}
