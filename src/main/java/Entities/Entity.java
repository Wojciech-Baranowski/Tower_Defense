package Entities;

import Game.Level;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

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
    public abstract void update(ProgramContainer pc, double passedTime, Level level);
    public abstract void render(ProgramContainer pc, Renderer r);
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

    public double getVel() {
        return vel;
    }
}
