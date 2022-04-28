package com.main.App.Build.App;

import com.main.App.Build.Interface.GameComputerInterface;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//TODO: Program the AI and replace placements with the decent icon
public class GameComputer implements GameComputerInterface {

    private final GameSetting gameSetting;
    private final GameMapDisplay gameMap;
    private final GameInput gameInput;
    private final Random random = new Random();

    private final Set<String> ownPlacement = new HashSet<>();

    private String placement;

    public GameComputer(GameSetting gameSetting, GameMapDisplay gameMap, GameInput gameInput) {
        this.gameSetting = gameSetting;
        this.gameMap = gameMap;
        this.gameInput = gameInput;
    }

    public void randomPlacement(Set<String> playerPlacement) {
        randomPlacementValues(playerPlacement);
        if (gameInput.checkPlacementInputIsValid(placement)) {
            ownPlacement.add(placement);
            gameMap.getGameMap()[gameInput.getFirstPlacement()][gameInput.getSecondPlacement()].setMapIcon(gameSetting.getSecondPlayerIcon());
        }
    }

    private void randomPlacementValues(Set<String> playerPlacement) {

        int randomPlacementValue;
        char randomPlacementLetter;

        while(true) {

            randomPlacementValue = random.nextInt(gameSetting.getxMapValue()) + 1;
            randomPlacementLetter = (char) ((char) 97 + random.nextInt(gameSetting.getyMapValue()-1));

            if (randomPlacementValue <= gameSetting.getxMapValue()) {
                this.placement = randomPlacementLetter +""+ randomPlacementValue;
                if (!playerPlacement.contains(placement) && !ownPlacement.contains(placement)) {
                    break;
                }
            }
        }
        System.out.println(placement);

    }

    public Set<String> getOwnPlacement() {
        return ownPlacement;
    }
}
