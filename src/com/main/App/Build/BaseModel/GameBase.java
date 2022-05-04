package com.main.App.Build.BaseModel;

import com.main.App.Build.App.*;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class GameBase {

    private final Scanner input = new Scanner(System.in);
    private Set<String> ownPlacement = new HashSet<>();

    private GameInput gameInput;
    private GameSetting gameSetting;
    private GameMapSetting gameMapSetting;
    private GameMapDisplay gameMapDisplay;
    private GameComputer gameComputer;
    private GameMap[][] gameMap;

    public GameBase() {
    }

    public GameBase(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

    public GameBase(GameMapSetting gameMapSetting) {
        this.gameMapSetting = gameMapSetting;
    }

    public GameBase(GameSetting gameSetting, GameMap[][] gameMap) {
        this.gameSetting = gameSetting;
        this.gameMap = gameMap;
    }

    public GameBase(GameInput gameInput) {
        this.gameInput = gameInput;
    }

    public GameBase(GameSetting gameSetting, GameMap[][] gameMap, GameInput gameInput, Set<String> ownPlacement) {
        this.gameInput = gameInput;
        this.gameSetting = gameSetting;
        this.gameMap = gameMap;
        this.ownPlacement = ownPlacement;
    }

    public GameSetting getGameSetting() {
        return gameSetting;
    }

    public void setGameSetting(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

    public GameMapSetting getGameMapSetting() {
        return gameMapSetting;
    }

    public GameMapDisplay getGameMapDisplay() {
        return gameMapDisplay;
    }

    public void setGameMapDisplay(GameMapDisplay gameMapDisplay) {
        this.gameMapDisplay = gameMapDisplay;
    }

    public GameComputer getGameComputer() {
        return gameComputer;
    }

    public void setGameComputer(GameComputer gameComputer) {
        this.gameComputer = gameComputer;
    }

    public Set<String> getOwnPlacement() {
        return ownPlacement;
    }

    public Scanner getInput() {
        return input;
    }

    public GameInput getGameInput() {
        return gameInput;
    }

    public GameMap[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap[][] gameMap) {
        this.gameMap = gameMap;
    }
}
