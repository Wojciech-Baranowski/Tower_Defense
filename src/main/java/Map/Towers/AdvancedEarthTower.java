package Map.Towers;

import Entities.Particles.Bullets.EarthBomb;
import Game.Level;
import Game.Stats;
import Map.Tile;
import engine.Image;
import engine.Pair;

public class AdvancedEarthTower extends EarthTower
{
    private static final Image ADVANCEDEARTHTOWER = new Image("/res/towers/advancedEarthTower.png",64, 64, 0);
    public AdvancedEarthTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(ADVANCEDEARTHTOWER, name, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }
    public void fire(Level level, Tile[] tiles, double passedTime) {
        if(passedTime - fireTimeStamp >= fireDelay)
        {
            fireTimeStamp = passedTime;
            Pair enemyId = targetChoose(level, tiles);
            if(enemyId.first >= 0) {
                bullets.add(new EarthBomb(new Image("/res/entities/bullets/earthBomb.png", 8, 8, 0), (int)posX + 32, (int)posY + 4, Stats.advancedEarthBulletVelocity, dmg, enemyId.second, enemyId.first, Stats.getAdvancedEarthSplashRange(), Stats.getAdvancedEarthSplashDmgPercentage()));
            }
        }
    }
}
