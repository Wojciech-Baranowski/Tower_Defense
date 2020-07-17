package Entities;

import Game.Assets;
import Game.gui.Gui;
import Game.Level;
import Game.Stats;
import Map.Road;
import Map.Towers.MagmaTower;
import engine.*;

public abstract class Enemy extends Entity implements Clickable
{
    String name;
    protected EnemyImageSheet sheet;
    protected double hp;
    protected int maxHp;
    protected int cost;
    protected int direction;
    protected int startDirection;
    protected int onMap = 0;
    protected int wave;
    protected int id;
    protected int reward;
    protected double velocityPercentage;
    protected Image healthBar;
    protected boolean alive;
    protected double slowDuration;
    protected double snareDuration;
    protected double dotaDuration;
    protected int currentDotaDamage;
    protected boolean isOnMagma;
    public Enemy(String name, EnemyImageSheet sheet, double posX, double posY, double vel, int maxHp, int cost, int startDirection, int wave, int id, int reward)
    {
        super(sheet.getImg()[1][1], posX, posY, vel);
        this.name = name;
        this.sheet = sheet;
        this.vel = vel;
        this.maxHp = maxHp;
        this.cost = cost;
        this.startDirection = startDirection;
        this.direction = startDirection;
        this.wave = wave;
        this.id = id;
        this.reward = reward;
        this.alive = true;
        this.hp = maxHp;
        this.velocityPercentage = 1;
        this.slowDuration = 0;
        this.snareDuration = 0;
        this.dotaDuration = 0;
        this.currentDotaDamage = 0;
        this.isOnMagma = false;
        this.healthBar = new Image("/entities/healthBarFull.png", 16, 2, 0);
        healthUpdate(0);
    }
    public void update(ProgramContainer pc, double passedTime, Level level)
    {
        if(isAlive())
        {
            onClick(pc, posX, posY, img.getW(), img.getH());
            if(snareDuration <= 0)
            move(level.getTileId());
            walkAnimate();
            if(snareDuration > 0)
                snareDuration -= (1.0 / 60.0);
            if(slowDuration <= 0)
                velocityPercentage = 1;
            else
                slowDuration -= (1.0 / 60.0);
            if(dotaDuration > 0)
            {
                healthUpdate((double)(currentDotaDamage) / 60.0);
                dotaDuration -= (1.0 / 60.0);
            }
            if(hasPassed())
            {
                Stats.hp -= cost;
            }
            if((isOnMagma == true) && (((Road)(pc.getWorld().getTiles()[(int)(posY / 64) * 16 + (int)(posX / 64)])).isMagma() == false))
            {
                isOnMagma = false;
                MagmaTower.scorch(this);
            }
        }
    }
    @Override
    public void render(ProgramContainer pc, Renderer r)
    {
        if(isAlive())
            r.drawImage(pc, img, (int)posX, (int)posY);
    }
    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if(isClick(pc, posX, posY, width, height))
        {
            Gui.enemyInfo(this, wave, id);
        }
    }
    public void healthBarRender(ProgramContainer pc, Renderer r)
    {
        if(isAlive())
            r.drawImage(pc, healthBar, (int)posX + (img.getW() - 16) / 2, (int)posY - 6);
    }
    public abstract void indUpdate(ProgramContainer pc, double passedTime);
    public abstract void indrender(ProgramContainer pc, Renderer r);
    public void move(int[] tileId)
    {
        if(img.getW() < 32)
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
        if(img.getH() < 32)
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
        if(img.getW() >= 32)
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
        if(img.getH() >= 32)
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
        if(isOnMap())
        {
            if(direction == 1)
                posY -= vel * velocityPercentage;
            if(direction == 2)
                posX += vel * velocityPercentage;
            if(direction == 3)
                posY += vel * velocityPercentage;
            if(direction == 4)
                posX -= vel * velocityPercentage;
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
    public void healthUpdate(double dmg)
    {
        hp -= dmg;
        if((hp <= 0) && (alive == true))
        {
            Stats.splitReward(reward);
            alive = false;
        }
        else if(hp > 0)
        {
            for(int i = 15; i >= (int)((16 * ((float)(hp) / (float)(maxHp)))); i--)
            {
                healthBar.getP()[i] = 0xFFFF0000;
                healthBar.getP()[i + 16] = 0xFFFF0000;
            }
        }
        if((Gui.currentWaveId == wave) && (Gui.currentEnemyId == id))
        {
            Gui.enemyInfo(this, wave, id);
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
    private void walkAnimate()
    {
        if(direction == 1)
        {
            img = sheet.getAnima()[0].updateLoop(img, World.tickCount);
        }
        else if(direction == 2)
        {
            img = sheet.getAnima()[1].updateLoop(img, World.tickCount);
        }
        else if(direction == 3)
        {
            img = sheet.getAnima()[2].updateLoop(img, World.tickCount);
        }
        else if(direction == 4)
        {
            img = sheet.getAnima()[3].updateLoop(img, World.tickCount);
        }
    }

    public int getCost() {
        return cost;
    }

    public double getHp() {
        return hp;
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

    public String getName() {
        return name;
    }

    public double getVelocityPercentage() {
        return velocityPercentage;
    }
    public void setVelocityPercentage(double velocityPercentage) {
        this.velocityPercentage = velocityPercentage;
    }

    public void setSlowDuration(double slowDuration) {
        this.slowDuration = slowDuration;
    }

    public double getSnareDuration() {
        return snareDuration;
    }

    public void setSnareDuration(double snareDuration) {
        this.snareDuration = snareDuration;
    }

    public double getDotaDuration() {
        return dotaDuration;
    }

    public double getCurrentDotaDamage() {
        return currentDotaDamage;
    }

    public void setDotaDuration(double dotaDuration) {
        this.dotaDuration = dotaDuration;
    }

    public void setCurrentDotaDamage(int currentDotaDamage) {
        this.currentDotaDamage = currentDotaDamage;
    }

    public boolean isOnMagma() {
        return isOnMagma;
    }

    public void setOnMagma(boolean onMagma) {
        isOnMagma = onMagma;
    }
}
