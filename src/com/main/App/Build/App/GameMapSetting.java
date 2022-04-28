package com.main.App.Build.App;

import com.main.App.Build.Interface.GameMapSettingInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GameMapSetting implements GameMapSettingInterface {

    private String mapIcon = "[ ]";

    private int xMapValue;
    private int yMapValue;
    private int currentMapSize;

    private final Scanner input = new Scanner(System.in);

    private static final int FIRST_MAP_SIZE_NUM = 0;
    private static final int SECOND_MAP_SIZE_NUM = 1;
    private static final String REGEX_FOR_INPUT = "[0-9]{0,10}[x][0-9]{0,10}";
    private static final char INPUT_PREFIX = 'x';
    private static final int GET_LAST_LOOP_VALUE = 1;

    private List<Integer> mapSizeList = new ArrayList<>();

    public String getMapIcon() {
        return mapIcon;
    }

    public void setMapIcon(String mapIcon) {
        this.mapIcon = mapIcon;
    }

    public void setGameMapSize(){

        if (checkIfMapSizeAvailable()) {
            this.xMapValue = this.mapSizeList.get(FIRST_MAP_SIZE_NUM);
            this.yMapValue = this.mapSizeList.get(SECOND_MAP_SIZE_NUM);
            this.currentMapSize = xMapValue * yMapValue;
        }

    }

    private boolean checkIfMapSizeAvailable() {

        String mapSize;

        while (true) {
            System.out.println("Please provide the game map size (3x3, 4x5..): ");
            String setGameMapSize = input.nextLine();
            if(Pattern.matches(REGEX_FOR_INPUT,setGameMapSize)) {
                mapSize = setGameMapSize;
                break;
            }
        }

        setMapSize(mapSize);
        return true;
    }

    private void setMapSize(String mapSize) {

        String setMapSize = "";
        boolean checkAfterXChar = false;

        for (int i = 0; i < mapSize.length(); i++){
            char mapSizeChar = mapSize.charAt(i);
            if (Character.isDigit(mapSizeChar)) {
                setMapSize += mapSizeChar;
                if (checkAfterXChar && mapSize.length()-GET_LAST_LOOP_VALUE == i) {
                    mapSizeList.add(Integer.parseInt(setMapSize));
                }
            }
            else if (Character.toLowerCase(mapSizeChar) == INPUT_PREFIX) {
                mapSizeList.add(Integer.parseInt(setMapSize));
                setMapSize = "";
                checkAfterXChar = true;
            }
        }
    }

    public int getCurrentMapSize() {
        return currentMapSize;
    }

    public int getxMapValue() {
        return xMapValue;
    }

    public int getyMapValue() {
        return yMapValue;
    }
}
