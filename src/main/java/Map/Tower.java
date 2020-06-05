package Map;

import Entities.Enemy;
import Entities.Particles.Bullet;
import Entities.Particles.Bullets.EarthBomb;
import Entities.Particles.Bullets.FireArrow;
import Entities.Particles.Bullets.WaterBullet;
import Game.Level;
import Game.Stats;
import engine.Image;
import engine.Pair;
import engine.ProgramContainer;
import engine.Renderer;

import java.util.*;

public abstract class Tower extends Tile
{
    String name;
    protected int upgradeLvl;
    protected double fireTimeStamp;
    protected Queue<Bullet> bullets;
    protected int towerId;
    protected int range;
    protected double fireDelay;
    protected boolean[] typePermission;
    public Tower(String name, Image image, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int range, double fireDelay, boolean[] typePermission)
    {
        super(image, posX, posY, id);
        this.name = name;
        this.upgradeLvl = upgradeLvl;
        this.fireTimeStamp = 0;
        this.towerId = towerId;
        this.range = range;
        this.fireDelay = fireDelay;
        this.typePermission = typePermission;
        bullets = new LinkedList<Bullet>();
    }

    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {
        fire(level, tiles, passedTime);
        holdClick(pc);
        int s = bullets.size();
        for(int i = 0; i < s; i++)
        {
            Bullet b = bullets.poll();
            b.update(level);
            if(!b.isDestination())
                bullets.add(b);
        }
        indUpdate(pc, tiles, passedTime, level);
    }
    public abstract void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level);
    public void render(ProgramContainer pc, Renderer r)
    {
        int s = bullets.size();
        for(int i = 0; i < s; i++)
        {
            Bullet b = bullets.poll();
            r.drawImage(pc, b.getImg(), (int)b.getPosX(), (int)b.getPosY());
            bullets.add(b);
        }
        indRender(pc, r);
    }
    public abstract void indRender(ProgramContainer pc, Renderer r);
    public void fire(Level level, Tile[] tiles, double passedTime)
    {
        if(passedTime - fireTimeStamp >= fireDelay)
        {
            fireTimeStamp = passedTime;
            if(towerId == 1)
            {
                Pair enemyId = targetChoose(level, tiles);
                if(enemyId.first >= 0)
                {
                    bullets.add(new FireArrow(new Image("/res/entities/bullets/fireArrow.png", 8, 2, 0), (int)posX + 32, (int)posY + 4, Stats.fireBulletVelocity, Stats.fireDmg, enemyId.second, enemyId.first));
                }
            }
            if(towerId == 3)
            {
                Pair enemyId = targetChoose(level, tiles);
                if(enemyId.first >= 0)
                {
                    bullets.add(new WaterBullet(new Image("/res/entities/bullets/waterBullet.png", 4, 8, 0), (int)posX + 32, (int)posY + 4, Stats.waterBulletVelocity, Stats.waterDmg, enemyId.second, enemyId.first));
                }
            }
            if(towerId == 4)
            {
                Pair enemyId = targetChoose(level, tiles);
                if(enemyId.first >= 0)
                {
                    bullets.add(new EarthBomb(new Image("/res/entities/bullets/earthBomb.png", 8, 8, 0), (int)posX + 32, (int)posY + 4, Stats.earthBulletVelocity, Stats.earthDmg, enemyId.second, enemyId.first, Stats.getEarthSplashRange(), Stats.getEarthSplashDmgPercentage()));
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
                if((level.getWaves()[i].getEnemies()[j].isAlive()) && (level.getWaves()[i].getEnemies()[j].getOnMap() > 0) && (isInRange(level.getWaves()[i].getEnemies()[j])))
                {
                    if(p.first == -1)
                    {
                        p.first = i;
                        p.second = j;
                    }
                    else
                    {
                        int ddd = ((int)(level.getWaves()[i].getEnemies()[j].getPosY() / 64) * 16 + (int)(level.getWaves()[i].getEnemies()[j].getPosX() / 64));
                        int eee = ((int)(level.getWaves()[p.first].getEnemies()[p.second].getPosY() / 64) * 16 + (int)(level.getWaves()[p.first].getEnemies()[p.second].getPosX() / 64));
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
        if((int)Math.sqrt(Math.pow((enemy.getPosX() - posX), 2) + (int)Math.pow((enemy.getPosY() - posY), 2)) <= range)
        return true;
        return false;
    }

    public int getRange() {
        return range;
    }

    public double getFireDelay() {
        return fireDelay;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setFireDelay(double fireDelay) {
        this.fireDelay = fireDelay;
    }
}
