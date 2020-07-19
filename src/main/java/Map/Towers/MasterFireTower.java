package Map.Towers;

import Entities.Particles.Bullets.FireBullet;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;

public class MasterFireTower extends AdvancedFireTower
{

    public MasterFireTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.MASTERFIRETOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);
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
                bullets.add(new FireBullet(Assets.FIREBULLET, (int)posX + 32, (int)posY + 4, Stats.bulletVelocity[8], damage, enemyId.second, enemyId.first, Stats.dotaDuration[8], Stats.dotaDamage[8]));
            }
        }
    }
}
