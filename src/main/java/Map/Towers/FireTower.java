package Map.Towers;

import Game.Gui;
import Game.Level;
import Map.Tile;
import Map.Tower;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

public class FireTower extends Tower
{
    private static final Image FIRETOWER = new Image("/res/towers/fireTower.png",64, 64, 0);
    public FireTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission)
    {
        super(name, FIRETOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r) {

    }

    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if(isClick(pc, posX, posY, width, height))
        {
            Gui.towerInfo(this);
        }
    }
}
