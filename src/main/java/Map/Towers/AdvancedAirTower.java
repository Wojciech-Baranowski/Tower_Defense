package Map.Towers;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import engine.Field;
import engine.Image;

public class AdvancedAirTower extends AirTower
{
    private static final Image ADVANCEDAIRTOWER = new Image("/res/towers/advancedAirTower.png",64, 64, 0);
    public AdvancedAirTower(String name, Tile[] tiles, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission, double attackSpeedBoost, double rangeBoost) {
        super(ADVANCEDAIRTOWER, name, tiles, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission, attackSpeedBoost, rangeBoost);
    }
    protected void boost(Tile[] tiles)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == FireTower.class) || (tiles[i].getClass() == WaterTower.class) || (tiles[i].getClass() == EarthTower.class) || (tiles[i].getClass() == AdvancedFireTower.class) || (tiles[i].getClass() == AdvancedWaterTower.class) || (tiles[i].getClass() == AdvancedEarthTower.class))
            {
                if(Math.pow((tiles[i].getPosX() - posX), 2) + Math.pow((tiles[i].getPosY() - posY), 2) <= Math.pow(range, 2))
                {
                    ((Tower)(tiles[i])).setFireDelay(((Tower)(tiles[i])).getFireDelay() * (1 + Stats.airAttackSpeedBoost) / (1 + Stats.advancedAirAttackSpeedBoost));
                    ((Tower)(tiles[i])).setRange((int)(((Tower)(tiles[i])).getRange() / (1 + Stats.airRangeBoost) * (1 + Stats.advancedAirRangeBoost)));
                    boostMark.add(new Field(BOOSTMARK, tiles[i].getPosX(), tiles[i].getPosY()));
                }
            }
        }
    }
    public static void boostCheck(Tile[] tiles, int id, int posX, int posY)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == AdvancedAirTower.class))
            {
                if(Math.pow((tiles[i].getPosX() - posX), 2) + Math.pow((tiles[i].getPosY() - posY), 2) <= Math.pow(((AdvancedAirTower)(tiles[i])).getRange(), 2))
                {
                    ((Tower)(tiles[id])).setFireDelay(((Tower)(tiles[id])).getFireDelay() / (1 + ((AdvancedAirTower)(tiles[i])).getAttackSpeedBoost()));
                    ((Tower)(tiles[id])).setRange((int)(((Tower)(tiles[id])).getRange() * (1 + ((AdvancedAirTower)(tiles[i])).getRangeBoost())));
                    ((AdvancedAirTower)(tiles[i])).getBoostMark().add(new Field(BOOSTMARK, posX, posY));
                }
            }
        }
    }
}
