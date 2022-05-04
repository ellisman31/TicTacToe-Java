package com.main.App.Build.App;

import com.main.App.Build.Interface.GameMapInterface;

public class GameMap implements GameMapInterface {

    private String mapIcon = "[ ]";

    public String getMapIcon() {
        return mapIcon;
    }

    public void setMapIcon(String mapIcon) {
        this.mapIcon = mapIcon;
    }
}
