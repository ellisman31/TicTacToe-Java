package com.main.App.Build.App;

import com.main.App.Build.BaseModel.GameBase;
import com.main.App.Build.Interface.GameInputInterface;

public class GameInput extends GameBase implements GameInputInterface {

    private static final int MINUS_PLACEMENT_VALUE = 1;
    private static final int FIRST_CHAR_VALUE = 0;
    private static final int STARTER_INDEX_FOR_PLACEMENT_CHECKER = 1;

    private int firstPlacement;
    private int secondPlacement;
    private String customErrorMessage;

    public GameInput() {
        super(new GameSetting());
    }

    public void inputInit() {
        getGameSetting().gameConfiguration();
        setGameMapDisplay(new GameMapDisplay(getGameSetting().getGameMapSetting().getGameMap(), getGameSetting()));
        setGameComputer(new GameComputer(getGameSetting(), getGameMapDisplay(), this));
    }

    public String askForPlacement() {
        System.out.println("\n" + getGameSetting().getPlayerName() + " turns! " + "Please provide your placement(C3,E6..):");

        String placement = getInput().nextLine();
        return placement.toLowerCase();
    }

    private void setPlacement(int firstPlacement, int secondPlacement) {
        this.firstPlacement = firstPlacement;
        this.secondPlacement = secondPlacement;
    }

    public boolean checkPlacementInputIsValid(String placement) {

        boolean isPlacementIsInputValid = false;

        if (!getGameSetting().getOwnPlacement().contains(placement) && !getGameComputer().getOwnPlacement().contains(placement)
                && (Character.isLetter(placement.charAt(FIRST_CHAR_VALUE)))) {

            char letterOfPlacement = placement.charAt(FIRST_CHAR_VALUE);
            int letterValue = letterOfPlacement - 97;
            String numberOfPlacement = "";
            int placementLength = placement.length();

            for (int i = STARTER_INDEX_FOR_PLACEMENT_CHECKER; i < placementLength; i++) {
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

        } else if (getGameSetting().getOwnPlacement().contains(placement) || getGameComputer().getOwnPlacement().contains(placement)) {
            setCustomErrorMessage("The placement is already taken!");
        } else {
            setCustomErrorMessage("The placement input is invalid please try again!");
        }

        return isPlacementIsInputValid;
    }

    private boolean sendPlacementChangeEvent(int letterValue, String numberOfPlacement) {
        int secondPlacementPart = Integer.parseInt(numberOfPlacement) - MINUS_PLACEMENT_VALUE;
        if (letterValue <= getGameSetting().getxMapValue() - MINUS_PLACEMENT_VALUE
                && secondPlacementPart <= getGameSetting().getyMapValue() - MINUS_PLACEMENT_VALUE) {
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

    public String getCustomErrorMessage() {
        return customErrorMessage;
    }
}
