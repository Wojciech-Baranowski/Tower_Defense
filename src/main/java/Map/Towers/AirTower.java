package Map.Towers;

import Game.gui.Gui;
import Game.Level;
import Map.Tile;
import Map.Tower;
import engine.Field;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

import java.util.Vector;

public class AirTower extends Tower
{
    private static final Image AIRTOWER = new Image("/res/towers/airTower.png",64, 64, 0);
    private static final Image BOOSTMARK = new Image("/res/towers/boostMark.png",64, 64, 0);
    private double attackSpeedBoost;
    private double rangeBoost;
    private Vector<Field> boostMark;
    public AirTower(String name, Tile[] tiles, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission, double attackSpeedBoost, double rangeBoost)
    {
        super(name, AIRTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
        this.attackSpeedBoost = attackSpeedBoost;
        this.rangeBoost = rangeBoost;
        boostMark = new Vector<>();
        boost(tiles);
    }
    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r)
    {
        for(int i = 0; i < boostMark.size(); i++)
        {
            r.drawImage(pc, boostMark.get(i).getImg(), (int)boostMark.get(i).getPosX(), (int)boostMark.get(i).getPosY());
        }
    }

    private void boost(Tile[] tiles)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == FireTower.class) || (tiles[i].getClass() == WaterTower.class) || (tiles[i].getClass() == EarthTower.class))
            {
                if(Math.pow((tiles[i].getPosX() - posX), 2) + Math.pow((tiles[i].getPosY() - posY), 2) <= Math.pow(range, 2))
                {
                    ((Tower)(tiles[i])).setFireDelay(((Tower)(tiles[i])).getFireDelay() / (1 + attackSpeedBoost));
                    ((Tower)(tiles[i])).setRange((int)(((Tower)(tiles[i])).getRange() * (1 + rangeBoost)));
                    boostMark.add(new Field(BOOSTMARK, tiles[i].getPosX(), tiles[i].getPosY()));
                }
            }
        }
    }
    public static void boostCheck(Tile[] tiles, int id, int posX, int posY)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == AirTower.class))
            {
                if(Math.pow((tiles[i].getPosX() - posX), 2) + Math.pow((tiles[i].getPosY() - posY), 2) <= Math.pow(((AirTower)(tiles[i])).getRange(), 2))
                {
                    ((Tower)(tiles[id])).setFireDelay(((Tower)(tiles[id])).getFireDelay() / (1 + ((AirTower)(tiles[i])).getAttackSpeedBoost()));
                    ((Tower)(tiles[id])).setRange((int)(((Tower)(tiles[id])).getRange() * (1 + ((AirTower)(tiles[i])).getRangeBoost())));
                    ((AirTower)(tiles[i])).getBoostMark().add(new Field(BOOSTMARK, posX, posY));
                }
            }
        }
    }

    public double getAttackSpeedBoost() {
        return attackSpeedBoost;
    }

    public Vector<Field> getBoostMark() {
        return boostMark;
    }

    public double getRangeBoost() {
        return rangeBoost;
    }
}
