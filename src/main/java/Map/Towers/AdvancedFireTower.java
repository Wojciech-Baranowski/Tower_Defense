package Map.Towers;

import Entities.Particles.Bullets.FireArrow;
import Game.Level;
import Game.Stats;
import Map.Tile;
import engine.Image;
import engine.Pair;

public class AdvancedFireTower extends FireTower
{
    private static final Image ADVANCEDFIRETOWER = new Image("/res/towers/advancedFireTower.png",64, 64, 0);
    public AdvancedFireTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(ADVANCEDFIRETOWER, name, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
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
                bullets.add(new FireArrow(new Image("/res/entities/bullets/fireArrow.png", 8, 2, 0), (int)posX + 32, (int)posY + 4, Stats.advancedFireBulletVelocity, dmg, enemyId.second, enemyId.first));
            }
        }
    }
}
