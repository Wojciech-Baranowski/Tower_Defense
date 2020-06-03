package Entities.Particles;

import Entities.Enemy;
import Entities.Entity;
import Game.Level;
import engine.Image;

public abstract class Bullet extends Entity
{
    protected int dmg;
    protected int targetId;
    protected int targetWaveId;
    protected boolean destination;
    public Bullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId)
    {
        super(img, posX, posY, vel);
        this.dmg = dmg;
        this.targetId = targetId;
        this.targetWaveId = targetWaveId;
        this.destination = false;
    }
    public void update(Level level)
    {
        move(level.getWaves()[targetWaveId].getEnemies()[targetId]);
        hit(level.getWaves()[targetWaveId].getEnemies()[targetId]);
        indUpdate(level);
    }
    public abstract void indUpdate(Level level);
    public void move(Enemy enemy)
    {
        double n = 0;
        double m = 0;
        if((posX - enemy.getPosX() < 0) && (posY - enemy.getPosY() < 0))
        {
            n = Math.round(((vel * (posX - enemy.getPosX())) / (posX + posY - enemy.getPosX() - enemy.getPosY())));
            m = Math.round(((vel * (posY - enemy.getPosY())) / (posX + posY - enemy.getPosX() - enemy.getPosY())));
        }
        else if((posX - enemy.getPosX() < 0) && (posY - enemy.getPosY() > 0))
        {
            n = Math.round(((vel * (posX - enemy.getPosX())) / (posX - posY - enemy.getPosX() + enemy.getPosY())));
            m = Math.round(((vel * (posY - enemy.getPosY())) / (posX - posY - enemy.getPosX() + enemy.getPosY())));
        }
        else if((posX - enemy.getPosX() > 0) && (posY - enemy.getPosY() < 0))
        {
            n = Math.round(((vel * (posX - enemy.getPosX())) / (-posX + posY + enemy.getPosX() - enemy.getPosY())));
            m = Math.round(((vel * (posY - enemy.getPosY())) / (-posX + posY + enemy.getPosX() - enemy.getPosY())));
        }
        else if((posX - enemy.getPosX() > 0) && (posY - enemy.getPosY() > 0))
        {
            n = Math.round((-(vel * (posX - enemy.getPosX())) / (posX + posY - enemy.getPosX() - enemy.getPosY())));
            m = Math.round((-(vel * (posY - enemy.getPosY())) / (posX + posY - enemy.getPosX() - enemy.getPosY())));
        }
        else if((posX == enemy.getPosX()) && (posY - enemy.getPosY() < 0))
        {
            n = 0;
            m = Math.round((int)vel);
        }
        else if((posX == enemy.getPosX()) && (posY - enemy.getPosY() > 0))
        {
            n = 0;
            m = Math.round(-(int)vel);
        }
        else if((posX - enemy.getPosX() < 0) && (posY == enemy.getPosY()))
        {
            n = Math.round((int)vel);
            m = 0;
        }
        else if((posX - enemy.getPosX() > 0) && (posY == enemy.getPosY()))
        {
            n = Math.round(-(int)vel);
            m = 0;
        }
        posX += (int)n;
        posY += (int)m;
    }

    private void hit(Enemy enemy)
    {
        if(Math.pow(vel, 2) >= Math.pow((enemy.getPosX() - posX), 2) + Math.pow((enemy.getPosY() - posY), 2))
        {
            destination = true;
            enemy.setHp(enemy.getHp() - dmg);
            if(enemy.getHp() <= 0)
            {
                enemy.setAlive(false);
                return;
            }
            enemy.healthUpdate();
        }
    }

    public boolean isDestination() {
        return destination;
    }

    public int getTargetId() {
        return targetId;
    }

    public int getTargetWaveId() {
        return targetWaveId;
    }
}
