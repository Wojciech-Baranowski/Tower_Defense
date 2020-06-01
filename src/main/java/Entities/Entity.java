package Entities;

import engine.Image;

public abstract class Entity
{
    protected Image img;
    protected int posX;
    protected int posY;
    protected float vel;
    public Entity(Image img, int posX, int posY, float vel)
    {
        this.img = img;
        this.posX = posX;
        this.posY = posY;
        this.vel = vel;
    }
    protected int currentGirdId()
    {
        return((posX / 64) + 16 * (posY / 64));
    }
    public Image getImg() {
        return img;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}
