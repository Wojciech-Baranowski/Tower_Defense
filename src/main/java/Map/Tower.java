package Map;
import Entities.Enemy;
import Entities.Particles.Bullet;
import Game.Level;
import Game.gui.AdvancedUpgradeMenu;
import Game.gui.BasicUpgradeMenu;
import Game.gui.BuildMenu;
import Game.gui.Gui;
import Map.Towers.*;
import engine.*;
import java.util.*;

public abstract class Tower extends Tile implements Clickable
{
    String name;
    protected int upgradeLvl;
    protected double fireTimeStamp;
    protected Queue<Bullet> bullets;
    protected int towerId;
    protected int dmg;
    protected int range;
    protected double fireDelay;
    protected boolean[] typePermission;
    public Tower(String name, Image image, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission)
    {
        super(image, posX, posY, id);
        this.name = name;
        this.upgradeLvl = upgradeLvl;
        this.fireTimeStamp = 0;
        this.towerId = towerId;
        this.dmg = dmg;
        this.range = range;
        this.fireDelay = fireDelay;
        this.typePermission = typePermission;
        bullets = new LinkedList<Bullet>();
    }

    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {
        fire(level, tiles, passedTime);
        int s = bullets.size();
        for(int i = 0; i < s; i++)
        {
            Bullet b = bullets.poll();
            b.update(pc, passedTime, level);
            if(!b.isDestination())
                bullets.add(b);
        }
        onClick(pc, posX, posY, img.getW(), img.getH());
        indUpdate(pc, tiles, passedTime, level);
    }
    public abstract void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level);
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawImage(pc, img, (int)posX, (int)posY);
        int s = bullets.size();
        for(int i = 0; i < s; i++)
        {
            Bullet b = bullets.poll();
            b.render(pc, r);
            bullets.add(b);
        }
        indRender(pc, r);
    }
    public abstract void indRender(ProgramContainer pc, Renderer r);
    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if(isClick(pc, posX, posY, width, height))
        {
            if((!BuildMenu.MENU.inBorder(pc, BuildMenu.MENU.getPosX(), BuildMenu.MENU.getPosY(), BuildMenu.MENU.getImg().getW(), BuildMenu.MENU.getImg().getH())) && (!BasicUpgradeMenu.MENU.inBorder(pc, BasicUpgradeMenu.MENU.getPosX(), BasicUpgradeMenu.MENU.getPosY(), BasicUpgradeMenu.MENU.getImg().getW(), BasicUpgradeMenu.MENU.getImg().getH())))
            {
                if(this.upgradeLvl == 1)
                {
                    BuildMenu.close();
                    AdvancedUpgradeMenu.close();
                    BasicUpgradeMenu.open(posX, posY, id, towerId, typePermission);
                }
                else if(this.upgradeLvl == 2)
                {
                    BuildMenu.close();
                    BasicUpgradeMenu.close();
                    AdvancedUpgradeMenu.open(posX, posY, id, towerId, typePermission);
                }
                if(this.getClass() == AirTower.class)
                    Gui.airTowerInfo((AirTower)(this));
                else if(this.getClass() == AdvancedAirTower.class)
                    Gui.airTowerInfo((AdvancedAirTower)(this));
                else if(this.getClass() == MasterAirTower.class)
                    Gui.airTowerInfo((MasterAirTower)(this));
                else if(this.getClass() == MagmaTower.class)
                    Gui.magmaTowerInfo((MagmaTower)(this));
                else if(this.getClass() == LightingTower.class)
                    Gui.lightingTowerInfo((LightingTower)(this));
                else
                    Gui.towerInfo(this);
            }
        }
    }
    public abstract void fire(Level level, Tile[] tiles, double passedTime);
    protected engine.Pair targetChoose(Level level, Tile[] tiles)
    {
        Pair p = new Pair(-1, -1);
        for(int i = 0; i < level.getWavesAmount(); i++)
        {
            if(level.getWaves()[i].isRunning() == false)
                break;
            for(int j = 0; j < level.getWaves()[i].getEnemies().length; j++)
            {
                if((level.getWaves()[i].getEnemies()[j].isAlive()) && (level.getWaves()[i].getEnemies()[j].getOnMap() == 1) && (isInRange(level.getWaves()[i].getEnemies()[j])))
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
    protected boolean isInRange(Enemy enemy)
    {
        if(Geometry.distance(enemy.getPosX(), enemy.getPosY(), posX, posY) <= range)
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

    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    public boolean[] getTypePermission() {
        return typePermission;
    }
}
