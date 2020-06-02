package Entities.Particles.Bullets;
import Entities.Particles.Bullet;
import engine.Image;

public class WaterBullet extends Bullet
{

    public WaterBullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId) {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
    }
}
