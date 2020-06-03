package Map.Towers;

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
    private double fireDelayBoost;
    private Vector<Field> boostMark;
    public AirTower(Tile[] tiles, int posX, int posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int range, double fireDelay, boolean[] typePermission, double fireDelayBoost)
    {
        super(AIRTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, range, fireDelay, typePermission);
        this.fireDelayBoost = fireDelayBoost;
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
            r.drawImage(pc, boostMark.get(i).getImg(), boostMark.get(i).getPosX(), boostMark.get(i).getPosY());
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
                    ((Tower)(tiles[i])).setFireDelay(((Tower)(tiles[i])).getFireDelay() / (1 + fireDelayBoost));
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
                    ((Tower)(tiles[id])).setFireDelay(((Tower)(tiles[id])).getFireDelay() / (1 + ((AirTower)(tiles[i])).getFireDelayBoost()));
                    ((AirTower)(tiles[i])).getBoostMark().add(new Field(BOOSTMARK, posX, posY));
                }
            }
        }
    }

    public double getFireDelayBoost() {
        return fireDelayBoost;
    }

    public Vector<Field> getBoostMark() {
        return boostMark;
    }
}
