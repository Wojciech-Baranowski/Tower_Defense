package Map.Towers;

import Entities.Particles.Bullets.EarthBomb;
import Game.Assets;
import Game.Stats;
import Game.Level;
import Map.Tile;
import Map.Tower;
import engine.Image;
import engine.Pair;
import engine.ProgramContainer;
import engine.Renderer;

public class EarthTower extends Tower
{

    public EarthTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission)
    {
        super(name, Assets.EARTHTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }
    public EarthTower(Image img, String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission)
    {
        super(name, img, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r) {

    }

    @Override
    public void fire(Level level, Tile[] tiles, double passedTime) {
        if(passedTime - fireTimeStamp >= fireDelay)
        {
            fireTimeStamp = passedTime;
            Pair enemyId = targetChoose(level, tiles);
            if(enemyId.first >= 0) {
                bullets.add(new EarthBomb(Assets.EARTHBOMB, (int)posX + 32, (int)posY + 4, Stats.earthBulletVelocity, Stats.earthDmg, enemyId.second, enemyId.first, Stats.getEarthSplashRange(), Stats.getEarthSplashDmgPercentage()));
            }
        }
    }
}
