package Map.Towers;

import Entities.Particles.Bullets.FireArrow;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import engine.Pair;

public class MasterFireTower extends AdvancedFireTower
{

    public MasterFireTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.MASTERFIRETOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
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
                bullets.add(new FireArrow(Assets.FIREARROW, (int)posX + 32, (int)posY + 4, Stats.bulletVelocity[8], Stats.damage[8], enemyId.second, enemyId.first));
            }
        }
    }
}
