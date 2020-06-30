package Map.Towers;

import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Road;
import Map.Tile;
import Map.Tower;
import engine.*;

public class MagmaTower extends Tower
{

    public MagmaTower(String name, Tile[] tiles, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.MAGMATOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
        magma(tiles);
    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r) {

    }

    @Override
    public void fire(Level level, Tile[] tiles, double passedTime) {

    }

    protected void magma(Tile[] tiles)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == Road.class))
            {
                if(Geometry.distance(posX, posY, tiles[i].getPosX(), tiles[i].getPosY()) <= range)
                {
                    ((Road)(tiles[i])).setMagma(true);
                }
            }
        }
    }
}
