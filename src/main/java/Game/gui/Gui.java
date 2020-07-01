package Game.gui;

import Entities.Enemy;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import Map.Towers.AirTower;
import engine.*;

public class Gui
{
    private static final Field background = new Field(Assets.GUI, 0, 0);
    private static NextWaveButton nextWave = new NextWaveButton(Assets.GUIBUTTON, Assets.GUIBUTTONCLICKED, 912, 200);
    private static Field hpEmblem = new Field(Assets.HP, 900, 10);
    //private static Field test = new Field(Assets.FONT.getLetters()[38], 100, 100);
    private static Field[] resourcesEmblem = new Field[]{new Field(Assets.FIRE32, 900, 48), new Field(Assets.AIR32, 900, 80), new Field(Assets.WATER32, 900, 112), new Field(Assets.EARTH32, 900, 144)};
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
    public static void update(ProgramContainer pc, Level level, double passedTime, Tile[] tiles)
    {
        nextWave.onClick(pc, nextWave.getPosX(), nextWave.getPosY(), nextWave.getImg().getW(), nextWave.getImg().getH(), level, passedTime);
        BuildMenu.update(pc, tiles, passedTime, level.getTileId());
        BasicUpgradeMenu.update(pc, tiles, passedTime, level.getTileId());
        AdvancedUpgradeMenu.update(pc, tiles, passedTime, level.getTileId());
    }
    public static void render(ProgramContainer pc, Renderer r, Level level, double passedTime)
    {
        r.drawStaticImage(pc, background.getImg(), (int)background.getPosX(), (int)background.getPosY());
        r.drawStaticText(pc, "    " + Stats.getHp(), 912, 16, 0xFF000000, 20);
        r.drawStaticText(pc, "   " + Stats.resources[0], 912, 48, 0xFF000000, 20);
        r.drawStaticText(pc, "   " + Stats.resources[1], 912, 80, 0xFF000000, 20);
        r.drawStaticText(pc, "   " + Stats.resources[2], 912, 112, 0xFF000000, 20);
        r.drawStaticText(pc, "   " + Stats.resources[3], 912, 144, 0xFF000000, 20);
        r.drawStaticImage(pc, hpEmblem.getImg(), (int)hpEmblem.getPosX(), (int)hpEmblem.getPosY());
        for(int i = 0; i < resourcesEmblem.length; i++)
            r.drawStaticImage(pc, resourcesEmblem[i].getImg(), (int)resourcesEmblem[i].getPosX(), (int)resourcesEmblem[i].getPosY());
        r.drawStaticText(pc, "Wave: " + (level.getCurrentWave() + 1) + "/" + level.getWavesAmount(), 912, 176, 0xFF000000, 15);
        r.drawStaticImage(pc, nextWave.getImg(), (int)nextWave.getPosX(), (int)nextWave.getPosY());
        //r.drawStaticImage(pc, test.getImg(), (int)test.getPosX(), (int)test.getPosY());
        r.drawStaticText(pc, "Next wave in:", 914, 204, 0xFF000000, 10);
        if(level.getCurrentWave() >= 0)
        {
            if((level.getCurrentWave() + 1 < level.getWavesAmount()) && (level.getWaveDelay()[level.getCurrentWave()] - passedTime + level.getWaves()[level.getCurrentWave()].getTimeStamp() >= 0))
            {
                r.drawStaticText(pc, "" + (double)((int)((level.getWaveDelay()[level.getCurrentWave()] - passedTime + level.getWaves()[level.getCurrentWave()].getTimeStamp()) * 10)) / (double)(10), 940, 224, 0xFF000000, 15);
            }
            else
            {
                r.drawStaticText(pc, "OO", 940, 224, 0xFF000000, 15);

            }
        }
        BuildMenu.render(pc, r);
        BasicUpgradeMenu.render(pc, r);
        AdvancedUpgradeMenu.render(pc, r);
        if(name != "")
        r.drawStaticText(pc, name, 16, 540, 0xFF000000, 10);
        if(dmg != 0)
        r.drawStaticText(pc,"Damage:   " + dmg, 320, 540, 0xFF000000, 10);
        if(attackSpeed != 0)
        r.drawStaticText(pc,"Attack Speed:   " + ((double)((int)(attackSpeed * 100)) / 100), 512, 540, 0xFF000000, 10);
        if(range != 0)
        r.drawStaticText(pc,"Range:   " + range, 784, 540, 0xFF000000, 10);
        if(attackSpeedBoost != 0)
            r.drawStaticText(pc,"Attack Speed Boost:  +" + ((double)((int)(attackSpeedBoost * 100)) / 100) + "%", 256, 540, 0xFF000000, 10);
        if(rangeBoost != 0)
            r.drawStaticText(pc,"Range Boost:  +" + ((double)((int)(rangeBoost * 100)) / 100) + "%", 720, 540, 0xFF000000, 10);
        if(hp != 0)
            r.drawStaticText(pc,"Hp:   " + hp, 320, 540, 0xFF000000, 10);
        if(vel != 0)
            r.drawStaticText(pc,"Velocity:   " + ((double)((int)(vel * 100)) / 100), 512, 540, 0xFF000000, 10);
        if(cost != 0)
            r.drawStaticText(pc,"Cost:   " + cost, 784, 540, 0xFF000000, 10);
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
            hp = (int)enemy.getHp();
            vel = enemy.getVel() * enemy.getVelocityPercentage();
            cost = enemy.getCost();
            currentWaveId = wave;
            currentEnemyId = id;
        }
    }
}

