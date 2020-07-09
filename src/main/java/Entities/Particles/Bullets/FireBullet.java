package Entities.Particles.Bullets;

import Entities.Enemy;
import Entities.Particles.Bullet;
import Game.Level;
import Game.Stats;
import engine.Image;

public class FireBullet extends Bullet
{
    private boolean flamed;
    public FireBullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId)
    {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
        flamed = false;
    }

    @Override
    public void indUpdate(Level level)
    {
        if((destination == true) && (flamed == false))
        {
            flame(level.getWaves()[targetWaveId].getEnemies()[targetId]);
            flamed = true;
        }
    }
    private void flame(Enemy enemy)
    {
        if(enemy.getDotaDuration() < Stats.fireDotaDuration[1])
        {
            enemy.setCurrentDotaDamage(Stats.fireDotaDamage[1]);
            enemy.setDotaDuration(Stats.fireDotaDuration[1]);
        }
    }
}
