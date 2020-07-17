package Entities.Particles.Bullets;

import Entities.Enemy;
import Entities.Particles.Bullet;
import Game.Level;
import Game.Stats;
import engine.Image;

public class FireBullet extends Bullet
{
    private boolean flamed;
    private double dotaDuration;
    private int dotaDamage;
    public FireBullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId, double dotaDuration, int dotaDamage)
    {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
        this.flamed = false;
        this.dotaDuration = dotaDuration;
        this.dotaDamage = dotaDamage;
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
        if(enemy.getDotaDuration() < dotaDuration)
        {
            enemy.setCurrentDotaDamage(dotaDamage);
            enemy.setDotaDuration(dotaDuration);
        }
    }
}
