package Map.Towers;

import Game.Assets;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import engine.Field;
import engine.Geometry;

public class MasterAirTower extends AdvancedAirTower
{
    public MasterAirTower(String name, Tile[] tiles, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission, double attackSpeedBoost, double rangeBoost) {
        super(name, Assets.MASTERAIRTOWER, tiles, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission, attackSpeedBoost, rangeBoost);
    }
    protected void boost(Tile[] tiles)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass().getSuperclass() == Tower.class) || (tiles[i].getClass().getSuperclass().getSuperclass() == Tower.class) || (tiles[i].getClass().getSuperclass().getSuperclass().getSuperclass() == Tower.class))
            {
                if(Geometry.distance(posX, posY, tiles[i].getPosX(), tiles[i].getPosY()) <= range)
                {
                    ((Tower)(tiles[i])).setFireDelay(((Tower)(tiles[i])).getFireDelay() * (1 + Stats.attackSpeedBoost[9]) / (1 + Stats.attackSpeedBoost[9]));
                    ((Tower)(tiles[i])).setRange((int)(((Tower)(tiles[i])).getRange() / (1 + Stats.rangeBoost[9]) * (1 + Stats.rangeBoost[9])));
                    boostMark.add(new Field(Assets.BOOSTMARK, tiles[i].getPosX(), tiles[i].getPosY()));
                }
            }
        }
    }
    public static void boostCheck(Tile[] tiles, int id, int posX, int posY)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == MasterAirTower.class))
            {
                if(Math.pow((tiles[i].getPosX() - posX), 2) + Math.pow((tiles[i].getPosY() - posY), 2) <= Math.pow(((MasterAirTower)(tiles[i])).getRange(), 2))
                {
                    ((Tower)(tiles[id])).setFireDelay(((Tower)(tiles[id])).getFireDelay() / (1 + ((MasterAirTower)(tiles[i])).getAttackSpeedBoost()));
                    ((Tower)(tiles[id])).setRange((int)(((Tower)(tiles[id])).getRange() * (1 + ((MasterAirTower)(tiles[i])).getRangeBoost())));
                    ((MasterAirTower)(tiles[i])).getBoostMark().add(new Field(Assets.BOOSTMARK, posX, posY));
                }
            }
        }
    }
}
