package Entities;

import engine.Image;

public abstract class Enemy extends Entity
{
    protected int hp;
    protected int maxHp;
    protected int cost;
    protected int direction;
    protected int startDirection;
    protected int onMap = 0;
    protected Image healthBar;
    protected boolean alive;
    public Enemy(Image img, double posX, double posY, double vel, int maxHp, int cost, int startDirection) {
        super(img, posX, posY, vel);
        this.vel = vel;
        this.maxHp = maxHp;
        this.cost = cost;
        this.startDirection = startDirection;
        this.direction = startDirection;
        this.alive = true;
        hp = maxHp;
        healthBar = new Image("/res/entities/healthBarFull.png", 16, 2, 0);
        healthUpdate();
    }
    public void move(int[] tileId)
    {

        if(img.getH() == 32)
        {
            if(((direction == 1) || (direction == 3)) && (((posY - 16 + 64) % 64) <= vel))
            {
                direction = directionChoose(tileId);
                if((direction == 2) || (direction == 4))
                {
                    posY += System.nanoTime() % 8;
                }
            }
        }
        if(img.getH() == 16)
        {
            if(((direction == 1) || (direction == 3)) && (((posY - 32 + 64) % 64) <= vel))
            {
                direction = directionChoose(tileId);
                if((direction == 2) || (direction == 4))
                {
                    posY += System.nanoTime() % 8 - 8;
                }
            }
        }
        if(img.getW() == 32)
        {
            if(((direction == 2) || (direction == 4)) && (((posX - 16 + 64) % 64) <= vel))
            {
                direction = directionChoose(tileId);
                 if((direction == 1) || direction == 3)
                 {
                     posX += System.nanoTime() % 8;
                 }
            }
        }
        if(img.getW() == 16)
        {
            if(((direction == 2) || (direction == 4)) && (((posX - 32 + 64) % 64) <= vel))
            {
                direction = directionChoose(tileId);
                if((direction == 1) || (direction == 3))
                {
                    posX += System.nanoTime() % 8 - 8;
                }
            }
        }
        if(isOnMap())
        {
            if(direction == 1)
                posY -= vel;
            if(direction == 2)
                posX += vel;
            if(direction == 3)
                posY += vel;
            if(direction == 4)
                posX -= vel;
        }
        else
        {
            if(direction == 1)
                posY -= 1.5;
            if(direction == 2)
                posX += 1.5;
            if(direction == 3)
                posY += 1.5;
            if(direction == 4)
                posX -= 1.5;
        }

    }
    public void healthUpdate()
    {
        for(int i = 15; i >= (16 * ((float)(hp) / (float)(maxHp))) - 1; i--)
        {
            healthBar.getP()[i] = 0xFFFF0000;
            healthBar.getP()[i + 16] = 0xFFFF0000;
        }
    }
    private boolean isOnMap()
    {
        if((posX >= 0) && (posX <= 1024) && (posY >= 0 ) && (posY <= 576))
        {
            onMap = 1;
            return true;
        }
        return false;
    }
    public boolean hasPassed()
    {
        if(((posX < 0) || (posX > 1024) || (posY < 0) || (posY > 576)) && (onMap == 1))
        {
            onMap = 2;
            return true;
        }
        return false;
    }
    private int directionChoose(int[] tileId)
    {
       if(isOnMap())
        return tileId[currentGirdId()] % 10;
       return startDirection;
    }

    public int getCost() {
        return cost;
    }

    public Image getHealthBar() {
        return healthBar;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getOnMap() {
        return onMap;
    }
}
