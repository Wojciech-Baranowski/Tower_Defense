package Map.Towers;

import Entities.Particles.Bullets.IceBullet;
import Entities.Particles.Bullets.LeafBullet;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import engine.Image;
import engine.Pair;
import engine.ProgramContainer;
import engine.Renderer;

public class LeafTower extends Tower
{

    public LeafTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.LEAFTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r) {

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
                bullets.add(new LeafBullet(Assets.LEAFBULLET, (int)posX + 32, (int)posY + 4, Stats.bulletVelocity[15], Stats.damage[15], enemyId.second, enemyId.first));
            }
        }
    }
}
