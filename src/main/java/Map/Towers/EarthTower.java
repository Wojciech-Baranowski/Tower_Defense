package Map.Towers;

import Game.Level;
import Map.Tile;
import Map.Tower;
import engine.ProgramContainer;

public class EarthTower extends Tower
{

    public EarthTower(String path, int posX, int posY, int width, int height, int id, int upgradeLvl, double fireTimeStamp, int towerId, int range, double fireDelay) {
        super(path, posX, posY, width, height, id, upgradeLvl, fireTimeStamp, towerId, range, fireDelay);
    }



    @Override
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }
}
