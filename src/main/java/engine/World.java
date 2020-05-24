package engine;

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
    private Tile[] tiles;
    private int[] tileId;

    private Wave testWave;
    private Stats stats;
    private String zer0 = "";
    public World(ProgramContainer pc) {

        this.paused = true;
        tiles = new Tile[144];
        tileId = new int[]{
                0   , 0   , 0   , 0   , 0   , 0   , 113 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 0   , 0   , 0   , 0   , 113 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 123 , 124 , 124 , 124 , 114 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 113 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 113 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 112 , 142 , 142 , 142 , 142 , 142 , 1243, 124 , 124 , 124 , 124 , 134 , 0   , 0   ,
                0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 113 , 0   , 0   , 0   , 0   , 131 , 0   , 0   ,
                124 , 124 , 124 , 124 , 124 , 124 , 124 , 124 , 114 , 0   , 0   , 0   , 0   , 121 , 124 , 124 ,
                0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
        };
        for(int i = 0; i < 144; i++)
        {
            Tile.tileInitializer(tiles, i, tileId[i]);
        }
        testWave = new Wave("1x10.2x5.1x10.", 6 * 64, 0, 32, (Road)tiles[6]);
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
            for(int i = 0; i < testWave.getEnemies().length; i++)
            {
                testWave.getEnemies()[i].move(tileId);
                if(testWave.getEnemies()[i].hasPassed())
                {
                    stats.setHp(stats.getHp() - testWave.getEnemies()[i].getCost());
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
        for(int i = 0; i < testWave.getEnemies().length; i++)
        {
            r.drawImage(pc, testWave.getEnemies()[i].getImg(), testWave.getEnemies()[i].getPosX(), testWave.getEnemies()[i].getPosY());
        }
        for(int i = 0; i < testWave.getEnemies().length; i++)
        {
            r.drawImage(pc, testWave.getEnemies()[i].getHealthBar(), testWave.getEnemies()[i].getPosX(), testWave.getEnemies()[i].getPosY() - 6);
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

