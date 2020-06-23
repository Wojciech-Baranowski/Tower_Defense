package Map.Towers;

import Entities.Particles.Bullets.EarthBomb;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import engine.Pair;

public class MasterEarthTower extends AdvancedEarthTower
{

    public MasterEarthTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.MASTEREARTHTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }
    @Override
    public void fire(Level level, Tile[] tiles, double passedTime) {
        if(passedTime - fireTimeStamp >= fireDelay)
        {
            fireTimeStamp = passedTime;
            Pair enemyId = targetChoose(level, tiles);
            if(enemyId.first >= 0) {
                bullets.add(new EarthBomb(Assets.EARTHBOMB, (int)posX + 32, (int)posY + 4, Stats.bulletVelocity[11], Stats.damage[11], enemyId.second, enemyId.first, Stats.earthSplashRange[2], Stats.earthSplashDmgPercentage[2]));
            }
        }
    }
}
