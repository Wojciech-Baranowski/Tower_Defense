package engine;

import Game.Level;
import Game.Stats;
import Game.Wave;
import Map.Road;
import Map.Tile;

import java.awt.event.KeyEvent;

public class World
{
    private double deltaTime;
    private double passedTime = 0;
    private boolean paused;
    private boolean isGrid;

    private Image measureGrid;
    private Image backgroundGrid;
    private Level level;
    private Tile[] tiles;
    private Stats stats;
    private String zer0 = "";
    public World(ProgramContainer pc)
    {
        this.paused = true;
        tiles = new Tile[144];
        level = JSONReader.parseJSON(FReader.read("levels/testLevel.txt"));
        //level = new Level("x.txt");
        //System.out.println(JSONReader.toJSON(level));
        //System.out.println(FReader.read("levels/testLevel.txt"));
        level.levelInit(tiles);
        measureGrid = new Image("/res/measureGrid.png", 1024, 576, 0);
        backgroundGrid = new Image("/res/backgroundGrid.png", 1024, 576, 0);
        stats = new Stats(20, 100);
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        showGrid(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        if(paused == false)
        {
            if(stats.getHp() <= 0)
                return;
            for(int i = 0; i < level.getWaves()[level.getCurrentWave()].getEnemies().length; i++)
            {
                level.getWaves()[level.getCurrentWave()].getEnemies()[i].move(level.getTileId());
                if(level.getWaves()[level.getCurrentWave()].getEnemies()[i].hasPassed())
                {
                    stats.setHp(stats.getHp() - level.getWaves()[level.getCurrentWave()].getEnemies()[i].getCost());
                    System.out.println(stats.getHp());
                }
            }
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc,backgroundGrid, 0, 0);
        for(int i = 0; i < 144; i++)
        {
            r.drawImage(pc, tiles[i].getImg(), tiles[i].getPosX(), tiles[i].getPosY());
        }
        for(int i = 0; i < level.getWaves()[level.getCurrentWave()].getEnemies().length; i++)
        {
            r.drawImage(pc, level.getWaves()[level.getCurrentWave()].getEnemies()[i].getImg(), level.getWaves()[level.getCurrentWave()].getEnemies()[i].getPosX(), level.getWaves()[level.getCurrentWave()].getEnemies()[i].getPosY());
        }
        for(int i = 0; i < level.getWaves()[level.getCurrentWave()].getEnemies().length; i++)
        {
            r.drawImage(pc, level.getWaves()[level.getCurrentWave()].getEnemies()[i].getHealthBar(), level.getWaves()[level.getCurrentWave()].getEnemies()[i].getPosX(), level.getWaves()[level.getCurrentWave()].getEnemies()[i].getPosY() - 6);
        }
        if(isGrid == true)
            r.drawStaticImage(pc, measureGrid, 0, 0);
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
    public void showGrid(ProgramContainer pc)
    {
        if((isGrid == true) && (pc.getInput().isKeyDown(KeyEvent.VK_G)))
        {
            isGrid = false;
        }
        else if((isGrid == false) && (pc.getInput().isKeyDown(KeyEvent.VK_G)))
        {
            isGrid = true;
        }
    }

    public boolean isPaused() {
        return paused;
    }
}

