package Map.Towers;

import engine.Image;

public class AdvancedWaterTower extends WaterTower
{
    private static final Image WATERTOWER = new Image("/res/towers/advancedWaterTower.png",64, 64, 0);
    public AdvancedWaterTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(WATERTOWER, name, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }
}
