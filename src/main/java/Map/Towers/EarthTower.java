package Map.Towers;

import Map.Tower;
import engine.Image;

public class EarthTower extends Tower
{
    private static final Image EARTHTOWER = new Image("/res/towers/earthTower.png",64, 64, 0);
    public EarthTower(int posX, int posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int range, double fireDelay, boolean[] typePermission)
    {
        super(EARTHTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, range, fireDelay, typePermission);
    }
}
