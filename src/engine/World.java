package engine;

import Entities.Enemies.CrystalShard;
import Entities.Enemy;
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
    private Field testField;
    private Tile[] tiles;
    private int[] tileId;

    private CrystalShard testEnemy;

    public World(ProgramContainer pc)
    {
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
            tileInitializer(i, tileId[i]);
        }
        testEnemy = new CrystalShard(6 * 64 + 32, 32);
        measureGrid = new Image("/res/measureGrid.png", 1024, 576, 0);
        backgroundGrid = new Image("/res/backgroundGrid.png", 1024, 576, 0);
        testField = new Field(100, 100, 100, 100, 1);
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        showGrid(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        if(paused == false)
        {
            testEnemy.move(tileId);
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc,backgroundGrid, 0, 0);
        //r.drawImage(pc, testField.getImg(), testField.getPosX(), testField.getPosY());
        for(int i = 0; i < 144; i++)
        {
            r.drawImage(pc, tiles[i].getImg(), tiles[i].getPosX(), tiles[i].getPosY());
        }
        r.drawImage(pc, testEnemy.getImg(), testEnemy.getPosX(), testEnemy.getPosY());
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

    private void tileInitializer(int i, int id)
    {
        if(id == 0)
            tiles[i] = new Tile("", (i % 16) * 64, (i / 16) * 64, 64, 64);
        if((int)(id / (Math.pow(10, (int)(Math.log10(id))))) == 1)
        {
            boolean dir[] = new boolean[4];
            int d = id % 10;
            while(id > 10)
            {
                dir[id % 10 - 1] = true;
                id /= 10;
            }
            String p = "/res/road/";
            for(int j = 1; j <= 4; j++)
            {
                if(dir[j - 1] == true)
                {
                    p += j;
                }
            }
            p += ".png";
            tiles[i] = new Road(p, (i % 16) * 64, (i / 16) * 64, 64, 64, d);
        }
    }

    public boolean isPaused() {
        return paused;
    }
}

