package Map;

import Entities.Enemy;
import Entities.Particles.Bullet;
import Entities.Particles.Bullets.FireArrow;
import Game.Level;
import Game.Wave;
import engine.Image;
import engine.Pair;
import engine.ProgramContainer;
import engine.Renderer;

import java.util.Vector;

public abstract class Tower extends Tile
{
    protected int upgradeLvl;
    protected double fireTimeStamp;
    protected Vector<Bullet> bullets;
    protected int towerId;
    protected int range;
    public Tower(String path, int posX, int posY, int width, int height, int id, int upgradeLvl, double fireTimeStamp, int towerId, int range)
    {
        super(path, posX, posY, width, height, id);
        this.upgradeLvl = upgradeLvl;
        this.fireTimeStamp = 0;
        this.towerId = towerId;
        this.range = range;
        bullets = new Vector<>();
    }

    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {
        fire(level, tiles, passedTime);
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

    public void fire(Level level, Tile[] tiles, double passedTime)
    {
        if(passedTime - fireTimeStamp >= 1)
        {
            fireTimeStamp = passedTime;
            if(towerId == 1)
            {
                Pair enemyId = targetChoose(level, tiles);
                if(enemyId.first >= 0)
                {
                    bullets.add(new FireArrow(new Image("/res/entities/bullets/fireArrow.png", 8, 2, 0), posX + 32, posY + 4, 4, 1, enemyId.second, enemyId.first));
                }
            }
        }
    }
    private engine.Pair targetChoose(Level level, Tile[] tiles)
    {
        Pair p = new Pair(-1, -1);
        for(int i = 0; i < level.getWavesAmount(); i++)
        {
            if(level.getWaves()[i].isRunning() == false)
                break;
            for(int j = 0; j < level.getWaves()[i].getEnemies().length; j++)
            {
                if(isInRange(level.getWaves()[i].getEnemies()[j]))
                {
                    if(p.first == -1)
                    {
                        p.first = i;
                        p.second = j;
                    }
                    else
                    {
                        int ddd = (level.getWaves()[i].getEnemies()[j].getPosY() / 64) * 16 + (level.getWaves()[i].getEnemies()[j].getPosX() / 64);
                        int eee = (level.getWaves()[p.first].getEnemies()[p.second].getPosY() / 64) * 16 + (level.getWaves()[p.first].getEnemies()[p.second].getPosX() / 64);
                        if(((Road)(tiles[ddd])).getPositionInOrder() < ((Road)(tiles[eee])).getPositionInOrder())
                        {
                            p.first = i;
                            p.second = j;
                        }
                    }
                }
            }
        }
        return p;
    }
    private boolean isInRange(Enemy enemy)
    {
        if((int)Math.sqrt(Math.pow(Math.abs((enemy.getPosX() - posX)), 2) + Math.pow(Math.abs((enemy.getPosY() - posY)), 2)) <= range)
        return true;
        return false;
    }
}
