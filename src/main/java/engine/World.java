package engine;

import Game.*;
import Game.gui.Gui;
import Map.Tile;

import java.awt.event.KeyEvent;

public class World implements State
{
    private double deltaTime;
    private double passedTime = 0;
    public static long tickCount = 0;
    private boolean paused;
    public static Field canvas;
    private Level level;
    private Stats stats;
    private EnemyStats enemyStats;
    public final static String zer0 = "Mateusz, sam jestes leb xD";
    public World(ProgramContainer pc)
    {
        this.paused = true;

        stats = JSONReader.parseJSONStats(FReader.read("data/towers.txt"));
        enemyStats = JSONReader.parseJSONEnemyStats(FReader.read("data/enemies.txt"));
        level = JSONReader.parseJSONLevel(FReader.read("levels/testLevel.txt"));
        canvas = new Field(new Image("/canvas.png", 1024, 576, 0), 0, 0);
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        if((paused == true) && (stats.getHp() > 0))
        {
            level.update(pc, passedTime);
        }
        Input.isHolding(pc);
        tickCount++;
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        level.render(pc, r);
        Gui.render(pc, r, level, passedTime);
        r.drawStaticImage(pc, canvas.getImg(), (int)canvas.getPosX(), (int)canvas.getPosY());
    }
    public void pause(ProgramContainer pc)
    {
        if((paused == true) && (pc.getInput().isKeyDown(KeyEvent.VK_P)))
        {
            paused = false;
        }
        else if((paused == false) && (pc.getInput().isKeyDown(KeyEvent.VK_P)))
        {
            paused = true;
        }
    }
}

