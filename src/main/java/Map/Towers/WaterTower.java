package Map.Towers;

import Map.Tower;
import engine.Image;

public class WaterTower extends Tower
{
    private static final Image WATERTOWER = new Image("/res/towers/waterTower.png",64, 64, 0);
    public WaterTower(int posX, int posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int range, double fireDelay, boolean[] typePermission)
    {
        super(WATERTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, range, fireDelay, typePermission);
    }
}
