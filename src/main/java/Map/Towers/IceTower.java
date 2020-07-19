package Map.Towers;

import Entities.Particles.Bullets.IceBullet;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import engine.ProgramContainer;
import engine.Renderer;

public class IceTower extends Tower
{

    public IceTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.ICETOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);

    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {

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
                bullets.add(new IceBullet(Assets.ICEBULLET, (int)posX + 32, (int)posY + 4, Stats.bulletVelocity[14], damage, enemyId.second, enemyId.first));
            }
        }
    }
}
