package engine;

import java.awt.event.KeyEvent;
import java.util.*;

public class World
{
    private double deltaTime;
    private double passedTime = 0;
    private boolean paused;
    private boolean isGrid;

    private Image measureGrid;
    private Image backgroundGrid;
    private Field testField;
    private Tile[][] tiles;

    public World(ProgramContainer pc)
    {
        this.paused = true;
        tiles = new Tile[16][9];
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                tiles[i][j] = new Tile("", i * 64, j * 64, 64, 64, 0);
            }
        }
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
        if(paused == true)
        {

        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc,backgroundGrid, 0, 0);
        //r.drawImage(pc, testField.getImg(), testField.getPosX(), testField.getPosY());
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                r.drawImage(pc, tiles[i][j].getImg(), tiles[i][j].getPosX(), tiles[i][j].getPosY());
            }
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
