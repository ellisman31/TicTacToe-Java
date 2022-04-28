package com.main.App.Build.App;

import com.main.App.Build.Interface.GameInputInterface;

import java.util.Scanner;
import java.util.Set;

public class GameInput implements GameInputInterface {

    private static final int MINUS_PLACEMENT_VALUE = 1;
    private static final int FIRST_CHAR_VALUE = 0;
    private static final int STARTER_INDEX_FOR_PLACEMENT_CHECKER = 1;

    private int firstPlacement;
    private int secondPlacement;
    private String customErrorMessage;

    private final Scanner input = new Scanner(System.in);
    private final GameSetting gameSetting = new GameSetting();
    private GameMapDisplay gameMap;
    private GameComputer gameComputer;
    private GameMapSetting gameMapSetting;

    private final Set<String> ownPlacement;
    private int gamePlacementStorageSize;

    public GameInput(Set<String> ownPlacement) {
        this.ownPlacement = ownPlacement;
    }

    public void gameInit() {
        gameSetting.gameConfiguration();
        this.gameMap = new GameMapDisplay(gameSetting.getGameMapCreation(), gameSetting);
        this.gameComputer = new GameComputer(gameSetting,gameMap,this);
        this.gameMapSetting = gameSetting.getGameMapSetting();
        placePlacement();
    }

    private void setPlacement(int firstPlacement, int secondPlacement) {
        this.firstPlacement = firstPlacement;
        this.secondPlacement = secondPlacement;
    }

    public void placePlacement() {

        while (true) {
            gameMap.gameMapDisplay();
            System.out.println("\n" + gameSetting.getPlayerName() + " turns! " + "Please provide your placement(C3,E6..):");

            String placement = input.nextLine();
            placement = placement.toLowerCase();

            if (checkPlacementInputIsValid(placement)) {

                ownPlacement.add(placement);
                gameMap.getGameMap()[firstPlacement][secondPlacement].setMapIcon(gameSetting.getFirstPlayerIcon());
                this.gamePlacementStorageSize = ownPlacement.size() + gameComputer.getOwnPlacement().size();

                if(gameMapSetting.getCurrentMapSize() == gamePlacementStorageSize) {
                    gameMap.gameMapDisplay();
                    break;
                }
                gameComputer.randomPlacement(ownPlacement);
            }
            else {
                System.out.println(customErrorMessage);
            }
            //TODO: implement GameRule class
        }

    }

    public boolean checkPlacementInputIsValid(String placement) {

        boolean isPlacementIsInputValid = false;

        if (!ownPlacement.contains(placement) && !gameComputer.getOwnPlacement().contains(placement)
                && (Character.isLetter(placement.charAt(FIRST_CHAR_VALUE)))) {

            char letterOfPlacement = placement.charAt(FIRST_CHAR_VALUE);
            int letterValue = letterOfPlacement - 97;
            String numberOfPlacement = "";
            int placementLength = placement.length();

            for (int i = STARTER_INDEX_FOR_PLACEMENT_CHECKER ; i < placementLength; i++) {
                char numberChar = placement.charAt(i);
                if (numberChar != '0' && Character.isDigit(numberChar)) {
                    numberOfPlacement += numberChar;
                } else {
                    isPlacementIsInputValid = false;
                    setCustomErrorMessage("The placement input is invalid please try again!");
                    break;
                }
                isPlacementIsInputValid = true;
            }

            if (isPlacementIsInputValid) {
                if (!sendPlacementChangeEvent(letterValue, numberOfPlacement)) {
                    setCustomErrorMessage("The placement is out of range! Please try again!");
                    isPlacementIsInputValid = false;
                }
            }

        } else if (ownPlacement.contains(placement) || gameComputer.getOwnPlacement().contains(placement)){
            setCustomErrorMessage("The placement is already taken!");
        }
        else {
            setCustomErrorMessage("The placement input is invalid please try again!");
        }

        return isPlacementIsInputValid;
    }

    private boolean sendPlacementChangeEvent(int letterValue, String numberOfPlacement) {
        int secondPlacementPart = Integer.parseInt(numberOfPlacement) - MINUS_PLACEMENT_VALUE;
        if (letterValue <= gameSetting.getxMapValue() - MINUS_PLACEMENT_VALUE
                && secondPlacementPart <= gameSetting.getyMapValue() - MINUS_PLACEMENT_VALUE) {
            setPlacement(letterValue, secondPlacementPart);
            return true;
        } else {
            return false;
        }
    }

    private void setCustomErrorMessage(String customErrorMessage) {
        this.customErrorMessage = customErrorMessage;
    }

    public int getFirstPlacement() {
        return firstPlacement;
    }

    public int getSecondPlacement() {
        return secondPlacement;
    }

}