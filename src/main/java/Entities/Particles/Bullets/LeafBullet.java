package Entities.Particles.Bullets;

import Entities.Enemy;
import Entities.Particles.Bullet;
import Game.Level;
import Game.Stats;
import engine.Image;

public class LeafBullet extends Bullet
{
    private boolean slowed;
    private boolean snared;
    public LeafBullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId) {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
        this.slowed = false;
        this.snared = false;
    }

    @Override
    public void indUpdate(Level level)
    {
        if((destination == true) && (slowed == false))
        {
            slow(level.getWaves()[targetWaveId].getEnemies()[targetId]);
            slowed = true;
        }
        if((destination == true) && (snared == false))
        {
            snare(level.getWaves()[targetWaveId].getEnemies()[targetId]);
            snared = true;
        }
    }
    private void slow(Enemy enemy)
    {
        if(enemy.getVelocityPercentage() > (1.0 - Stats.leafSlowPercentage))
        {
            enemy.setVelocityPercentage(1.0 - Stats.leafSlowPercentage);
            enemy.setSlowDuration(Stats.leafSlowDuration);
        }
    }
    private void snare(Enemy enemy)
    {
        if((enemy.getSnareDuration() < Stats.leafSnareDuration) && (Stats.leafSnareChance * 100 > System.nanoTime() % 100))
        {
            enemy.setSnareDuration(Stats.leafSnareDuration);
        }
    }
}
