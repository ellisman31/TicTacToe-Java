package com.main.App.Build.App;

import java.util.*;

public class Game{

    private final Set<String> ownPlacement = new HashSet<>();

    public void gameStarter() {
        GameInput gameInput = new GameInput(ownPlacement);
        gameInput.gameInit();
    }

    public Set<String> getOwnPlacement() {
        return ownPlacement;
    }
}
