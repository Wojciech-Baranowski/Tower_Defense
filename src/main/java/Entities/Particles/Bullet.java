package Entities.Particles;

import Entities.Enemy;
import Entities.Entity;
import Entities.Particles.Bullets.LeafBullet;
import Game.Level;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

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
    @Override
    public void update(ProgramContainer pc, double passedTime, Level level)
    {
        move(level.getWaves()[targetWaveId].getEnemies()[targetId]);
        hit(level.getWaves()[targetWaveId].getEnemies()[targetId]);
        indUpdate(level);
    }
    @Override
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawImage(pc,img, (int)posX, (int)posY);
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
            enemy.healthUpdate(dmg);
        }
    }

    public boolean isDestination() {
        return destination;
    }
}
