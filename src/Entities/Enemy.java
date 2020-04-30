package Entities;

import engine.Image;

public class Enemy extends Entity
{
    protected int hp;
    protected int cost;
    protected int moveProgress;
    protected int direction;
    public Enemy(Image img, int posX, int posY, float vel, int hp, int cost) {
        super(img, posX, posY, vel);
        this.hp = hp;
        this.cost = cost;
        this.moveProgress = 0;
    }
    public void move(int[] tileId)
    {
        if(moveProgress == 0)
            direction = directionChoose(tileId);
        if(direction == 1)
            posY -= Math.min(64 - moveProgress, vel);
        if(direction == 2)
            posX += Math.min(64 - moveProgress, vel);
        if(direction == 3)
            posY += Math.min(64 - moveProgress, vel);
        if(direction == 4)
            posX -= Math.min(64 - moveProgress, vel);
        moveProgress += vel;
        if(moveProgress >= 64)
            moveProgress = 0;
    }
    protected int directionChoose(int[] tileId)
    {
        return tileId[currentGirdId()] % 10;
    }
}
