package Map.Towers;

import Entities.Particles.Bullets.EarthBullet;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;

public class MasterEarthTower extends AdvancedEarthTower
{

    public MasterEarthTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.MASTEREARTHTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);
    }
    @Override
    public void fire(Level level, Tile[] tiles, double passedTime) {
        if(passedTime - fireTimeStamp >= fireDelay)
        {
            fireTimeStamp = passedTime;
            Pair enemyId = targetChoose(level, tiles);
            if(enemyId.first >= 0) {
                bullets.add(new EarthBullet(Assets.EARTHBULLET, (int)posX + 32, (int)posY + 4, Stats.bulletVelocity[11], damage, enemyId.second, enemyId.first, Stats.splashRange[11], Stats.splashDamage[11]));
            }
        }
    }
}
