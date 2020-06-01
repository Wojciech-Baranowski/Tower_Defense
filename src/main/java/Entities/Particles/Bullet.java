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
    public Bullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId)
    {
        super(img, posX, posY, vel);
        this.dmg = dmg;
        this.targetId = targetId;
        this.targetWaveId = targetWaveId;
    }
    public void update(Enemy enemy)
    {
        move(enemy);
    }
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

    public int getTargetId() {
        return targetId;
    }

    public int getTargetWaveId() {
        return targetWaveId;
    }
}
