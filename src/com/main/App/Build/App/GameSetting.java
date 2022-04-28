package com.main.App.Build.App;

import com.main.App.Build.Interface.GameSettingInterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameSetting implements GameSettingInterface {

    private String playerName;

    private final String firstPlayerIcon = " X ";
    private final String secondPlayerIcon = " O ";
    private final Scanner input = new Scanner(System.in);
    private GameMapSetting[][] gameMapCreation;
    private GameMapSetting gameMapSetting = new GameMapSetting();

    private int xMapValue;
    private int yMapValue;

    private final Set<String> ownPlacement = new HashSet<>();

    public void gameConfiguration() {
        gameMapSetting.setGameMapSize();
        this.xMapValue = gameMapSetting.getxMapValue();
        this.yMapValue = gameMapSetting.getyMapValue();
        this.gameMapCreation = new GameMapSetting[xMapValue][yMapValue];
        setPlayerName();
    }

    private void setPlayerName() {
        System.out.println("Before start to play please provide a name: ");
        this.playerName = input.nextLine();
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getFirstPlayerIcon() {
        return firstPlayerIcon;
    }

    public String getSecondPlayerIcon() {
        return secondPlayerIcon;
    }

    public int getxMapValue() {
        return xMapValue;
    }

    public int getyMapValue() {
        return yMapValue;
    }

    public GameMapSetting[][] getGameMapCreation() {
        return gameMapCreation;
    }

    public GameMapSetting getGameMapSetting() {
        return gameMapSetting;
    }

    public Set<String> getOwnPlacement() {
        return ownPlacement;
    }
}
