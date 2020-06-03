package Map.Towers;

import Map.Tower;
import engine.Image;

public class FireTower extends Tower
{
    private static final Image FIRETOWER = new Image("/res/towers/fireTower.png",64, 64, 0);
    public FireTower(int posX, int posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int range, double fireDelay, boolean[] typePermission)
    {
        super(FIRETOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, range, fireDelay, typePermission);
    }

}
