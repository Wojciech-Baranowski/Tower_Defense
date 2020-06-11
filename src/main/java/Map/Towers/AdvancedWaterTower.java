package Map.Towers;

import Entities.Particles.Bullets.FireArrow;
import Entities.Particles.Bullets.WaterBullet;
import Game.Level;
import Game.Stats;
import Map.Tile;
import engine.Image;
import engine.Pair;

public class AdvancedWaterTower extends WaterTower
{
    private static final Image WATERTOWER = new Image("/res/towers/advancedWaterTower.png",64, 64, 0);
    public AdvancedWaterTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(WATERTOWER, name, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }
    @Override
    public void fire(Level level, Tile[] tiles, double passedTime)
    {
        if(passedTime - fireTimeStamp >= fireDelay)
        {
            fireTimeStamp = passedTime;
            Pair enemyId = targetChoose(level, tiles);
            if(enemyId.first >= 0)
            {
                bullets.add(new WaterBullet(new Image("/res/entities/bullets/waterBullet.png", 4, 8, 0), (int)posX + 32, (int)posY + 4, Stats.advancedWaterBulletVelocity, dmg, enemyId.second, enemyId.first));
            }
        }
    }
}
