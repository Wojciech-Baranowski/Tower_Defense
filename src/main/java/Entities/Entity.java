package Entities;

import engine.Button;
import engine.Image;

public abstract class Entity
{
    protected Image img;
    protected double posX;
    protected double posY;
    protected double vel;
    public Entity(Image img, double posX, double posY, double vel)
    {
        this.img = img;
        this.posX = posX;
        this.posY = posY;
        this.vel = vel;
    }
    protected int currentGirdId()
    {
        return(((int)posX / 64) + 16 * ((int)posY / 64));
    }
    public Image getImg() {
        return img;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
