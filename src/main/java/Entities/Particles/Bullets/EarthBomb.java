package Entities.Particles.Bullets;

import Entities.Particles.Bullet;
import Game.Level;
import engine.Image;

public class EarthBomb extends Bullet
{
    private boolean splaphed;
    private int splashRange;
    private double splashPercentage;
    public EarthBomb(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId, int splashRange, double splashPercentage)
    {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
        this.splaphed = false;
        this.splashRange = splashRange;
        this.splashPercentage = splashPercentage;
    }
    @Override
    public void indUpdate(Level level)
    {
        splash(level);
    }
    public void splash(Level level)
    {
        if((destination == true) && (splaphed == false))
        {
            splaphed = true;
            for(int i = 0; i < level.getWavesAmount(); i++)
            {
                if(level.getWaves()[i].isRunning())
                {
                    for(int j = 0; j < level.getWaves()[i].getEnemies().length; j++)
                    {
                        if((Math.pow(level.getWaves()[i].getEnemies()[j].getPosX() - posX, 2) + Math.pow(level.getWaves()[i].getEnemies()[j].getPosY() - posY, 2) <= Math.pow(splashRange, 2)))
                        {
                            level.getWaves()[i].getEnemies()[j].setHp(level.getWaves()[i].getEnemies()[j].getHp() - (int)((double)dmg * (splashPercentage)));
                            if(level.getWaves()[i].getEnemies()[j].getHp() <= 0)
                            {
                                level.getWaves()[i].getEnemies()[j].setAlive(false);
                                continue;
                            }
                            level.getWaves()[i].getEnemies()[j].healthUpdate();
                        }
                    }
                }
                else
                    break;
            }
        }
    }
}
