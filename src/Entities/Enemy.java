package Entities;

import Map.Road;
import engine.Image;

public class Enemy extends Entity
{
    protected int hp;
    protected int cost;
    protected int direction;
    protected int startDirection;
    public Enemy(Image img, int posX, int posY, float vel, int hp, int cost, int startDirection) {
        super(img, posX, posY, vel);
        this.hp = hp;
        this.cost = cost;
        this.startDirection = startDirection;
        this.direction = startDirection;
    }
    public void move(int[] tileId)
    {
        if(((direction == 1) || (direction == 3)) && (posY % 32 <= vel) && (posY % 64 > vel))
        {
            direction = directionChoose(tileId);
            if((direction == 2) || (direction == 4))
            {
                posY += System.nanoTime() % 16 - 8;
            }
        }
        else if(((direction == 2) || (direction == 4)) && (posX % 32 <= vel) && (posX % 64 > vel))
        {
            direction = directionChoose(tileId);
            if((direction == 1) || (direction == 3))
            {
                posX += System.nanoTime() % 16 - 8;
            }
        }
        if(direction == 1)
            posY -= vel;
        if(direction == 2)
            posX += vel;
        if(direction == 3)
            posY += vel;
        if(direction == 4)
            posX -= vel;
    }
    private int directionChoose(int[] tileId)
    {
       if(currentGirdId() >= 0)
        return tileId[currentGirdId()] % 10;
       return startDirection;
    }
}
