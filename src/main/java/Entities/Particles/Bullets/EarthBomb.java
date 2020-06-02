package Entities.Particles.Bullets;

import Entities.Particles.Bullet;
import engine.Image;

public class EarthBomb extends Bullet
{
    public EarthBomb(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId)
    {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
    }
}
