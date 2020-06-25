package Entities.Particles.Bullets;

import Entities.Particles.Bullet;
import Game.Level;
import Game.Stats;
import engine.Image;

public class IceBullet extends Bullet
{
    private boolean headShoted;
    public IceBullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId) {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
        this.headShoted = false;
    }

    @Override
    public void indUpdate(Level level) {
        headShot(level);
    }
    private void headShot(Level level)
    {
        if((destination == true) && (headShoted == false))
        {
            headShoted = true;
            if(System.nanoTime() % 100 < Stats.iceHeadshotChance * 100)
            {
                level.getWaves()[targetWaveId].getEnemies()[targetId].healthUpdate(9999999);
            }
        }
    }
}
