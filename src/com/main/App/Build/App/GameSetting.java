package com.main.App.Build.App;

import com.main.App.Build.BaseModel.GameBase;
import com.main.App.Build.Interface.GameSettingInterface;

public class GameSetting extends GameBase implements GameSettingInterface {

    private String playerName;

    private final String firstPlayerIcon = " X ";
    private final String secondPlayerIcon = " O ";

    private int xMapValue;
    private int yMapValue;

    public GameSetting() {
        super(new GameMapSetting());
    }

    public void gameConfiguration() {
        getGameMapSetting().setGameMapSize();
        this.xMapValue = getGameMapSetting().getxMapValue();
        this.yMapValue = getGameMapSetting().getyMapValue();
        setPlayerName();
    }

    private void setPlayerName() {
        System.out.println("Before start to play please provide a name: ");
        this.playerName = getInput().nextLine();
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
}
