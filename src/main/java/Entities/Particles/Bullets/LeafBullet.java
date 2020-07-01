package Entities.Particles.Bullets;

import Entities.Particles.Bullet;
import Game.Level;
import Game.Stats;
import engine.Image;

public class LeafBullet extends Bullet
{
    public LeafBullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId) {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
    }

    @Override
    public void indUpdate(Level level) {
        slow(level);
    }
    private void slow(Level level)
    {
        if(level.getWaves()[targetWaveId].getEnemies()[targetId].getVelocityPercentage() > (1.0 - Stats.leafSlowPercentage))
        {
            level.getWaves()[targetWaveId].getEnemies()[targetId].setVelocityPercentage(1.0 - Stats.leafSlowPercentage);
            level.getWaves()[targetWaveId].getEnemies()[targetId].setSlowDuration(3);
        }
    }
}
