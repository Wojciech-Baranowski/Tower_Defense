package Map;

import Entities.Particles.Bullet;
import Entities.Particles.Bullets.FireArrow;
import Game.Level;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

import java.util.Vector;

public abstract class Tower extends Tile
{
    protected int upgradeLvl;
    protected double fireTimeStamp;
    protected Vector<Bullet> bullets;
    protected int towerId;
    public Tower(String path, int posX, int posY, int width, int height, int id, int upgradeLvl, double fireTimeStamp, int towerId)
    {
        super(path, posX, posY, width, height, id);
        this.upgradeLvl = upgradeLvl;
        this.fireTimeStamp = 0;
        this.towerId = towerId;
        bullets = new Vector<>();
    }

    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {
        fire(passedTime);
        for(int i = 0; i < bullets.size(); i++)
        {
            bullets.get(i).update(level.getWaves()[bullets.get(i).getTargetWaveId()].getEnemies()[bullets.get(i).getTargetId()]);
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        for(int i = 0; i < bullets.size(); i++)
        {
            r.drawImage(pc, bullets.get(i).getImg(), bullets.get(i).getPosX(), bullets.get(i).getPosY());
        }
    }

    public void fire(double passedTime)
    {
        if(passedTime - fireTimeStamp >= 1)
        {
            fireTimeStamp = passedTime;
            if(towerId == 1)
            {
                bullets.add(new FireArrow(new Image("/res/entities/bullets/fireArrow.png", 8, 2, 0), posX + 32, posY + 4, 4, 1, 0, 0));
            }
        }
    }
}
