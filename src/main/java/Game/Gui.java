package Game;

import Entities.Enemy;
import Map.Tower;
import Map.Towers.AirTower;
import engine.*;

public class Gui
{
    private static final Field background = new Field("/res/gui.png", 0, 0, 1024, 576, 0xFF641D54);;
    private static Button nextWave = new Button("/res/guiButton.png", "/res/guiButtonClicked.png", 912, 200, 96, 48, 0xFF641D54);;
    private static String name = "";
    private static int dmg = 0;
    private static double attackSpeed = 0;
    private static int range = 0;
    private static double attackSpeedBoost = 0;
    private static double rangeBoost = 0;
    private static int hp = 0;
    private static double vel = 0;
    private static int cost = 0;
    public static int currentWaveId = -1;
    public static int currentEnemyId = -1;
    public static void update(ProgramContainer pc, Level level, double passedTime)
    {
        nextWave.onClick(pc, nextWave.getPosX(), nextWave.getPosY(), nextWave.getImg().getW(), nextWave.getImg().getH());
        if(nextWave.isClick(pc, nextWave.getPosX(), nextWave.getPosY(), nextWave.getImg().getW(), nextWave.getImg().getH()))
        {
            if(level.getWaves()[0].isRunning() == false)
            {
                level.getWaves()[0].setRunning(true);
                level.getWaves()[0].setTimeStamp(passedTime);
                level.setCurrentWave(0);
            }
            else if(level.getCurrentWave() + 1 < level.getWavesAmount())
            {
                level.getWaveDelay()[level.getCurrentWave()] = 0;
            }
        }
    }
    public static void render(ProgramContainer pc, Renderer r, Stats stats, Level level, double passedTime)
    {
        r.drawStaticImage(pc, background.getImg(), (int)background.getPosX(), (int)background.getPosY());
        r.drawStaticText(pc, "HP: " + stats.getHp(), 912, 16, 0xFF000000, 3);
        r.drawStaticText(pc, "F: " + stats.getFire(), 912, 48, 0xFF000000, 3);
        r.drawStaticText(pc, "A: " + stats.getAir(), 912, 80, 0xFF000000, 3);
        r.drawStaticText(pc, "W: " + stats.getWater(), 912, 112, 0xFF000000, 3);
        r.drawStaticText(pc, "E: " + stats.getEarth(), 912, 144, 0xFF000000, 3);
        r.drawStaticText(pc, "Wave: " + (level.getCurrentWave() + 1) + "/" + level.getWavesAmount(), 912, 176, 0xFF000000, 4);
        r.drawStaticImage(pc, nextWave.getImg(), (int)nextWave.getPosX(), (int)nextWave.getPosY());
        r.drawStaticText(pc, "Next wave in:", 914, 204, 0xFF000000, 5);
        if(level.getCurrentWave() >= 0)
        {
            if((level.getCurrentWave() + 1 < level.getWavesAmount()) && (level.getWaveDelay()[level.getCurrentWave()] - passedTime + level.getWaves()[level.getCurrentWave()].getTimeStamp() >= 0))
            {
                r.drawStaticText(pc, "" + (double)((int)((level.getWaveDelay()[level.getCurrentWave()] - passedTime + level.getWaves()[level.getCurrentWave()].getTimeStamp()) * 10)) / (double)(10), 940, 224, 0xFF000000, 4);
            }
            else
            {
                r.drawStaticText(pc, "OO", 940, 224, 0xFF000000, 4);

            }
        }
        if(name != "")
        r.drawStaticText(pc, name, 16, 540, 0xFF000000, 3);
        if(dmg != 0)
        r.drawStaticText(pc,"Damage:   " + dmg, 320, 540, 0xFF000000, 3);
        if(attackSpeed != 0)
        r.drawStaticText(pc,"Attack Speed:   " + attackSpeed, 512, 540, 0xFF000000, 3);
        if(range != 0)
        r.drawStaticText(pc,"Range:   " + range, 784, 540, 0xFF000000, 3);
        if(attackSpeedBoost != 0)
            r.drawStaticText(pc,"Attack Speed Boost:  +" + attackSpeedBoost + "%", 320, 540, 0xFF000000, 3);
        if(rangeBoost != 0)
            r.drawStaticText(pc,"Range Boost:  +" + rangeBoost + "%", 784, 540, 0xFF000000, 3);
        if(hp != 0)
            r.drawStaticText(pc,"Hp:   " + hp, 320, 540, 0xFF000000, 3);
        if(vel != 0)
            r.drawStaticText(pc,"Velocity:   " + vel, 512, 540, 0xFF000000, 3);
        if(cost != 0)
            r.drawStaticText(pc,"Cost:   " + cost, 784, 540, 0xFF000000, 3);
    }
    private static void clear()
    {
        name = "";
        dmg = 0;
        attackSpeed = 0;
        range = 0;
        attackSpeedBoost = 0;
        rangeBoost = 0;
        hp = 0;
        vel = 0;
        cost = 0;
        currentWaveId = -1;
        currentEnemyId = -1;
    }
    public static void towerInfo(Tower tower)
    {
        clear();
        name = tower.getName();
        dmg = tower.getDmg();
        attackSpeed = 1 / tower.getFireDelay();
        range = tower.getRange();
    }
    public static void airTowerInfo(AirTower tower)
    {
        clear();
        name = tower.getName();
        attackSpeedBoost = tower.getAttackSpeedBoost() * 100;
        rangeBoost = (int)(tower.getRangeBoost() * 100);
    }
    public static void enemyInfo(Enemy enemy, int wave, int id)
    {
        clear();
        if(enemy.getHp() > 0)
        {
            name = enemy.getName();
            hp = enemy.getHp();
            vel = enemy.getVel();
            cost = enemy.getCost();
            currentWaveId = wave;
            currentEnemyId = id;
        }
    }
}

