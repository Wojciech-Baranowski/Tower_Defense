package engine;

import Game.*;
import Map.Tile;
import com.alibaba.fastjson.JSONObject;

import java.awt.event.KeyEvent;

public class World
{
    private double deltaTime;
    private double passedTime = 0;

    private boolean paused;
    private boolean isGrid;

    private Image measureGrid;
    private Image backgroundGrid;
    private Image background;

    private Level level;
    private Gui gui;
    private Tile[] tiles;
    private Stats stats;
    private Prices prices;
    public final static String zer0 = "Mateusz, sam jestes leb xD";
    public World(ProgramContainer pc)
    {
        measureGrid = new Image("/res/measureGrid.png", 1024, 576, 0);
        backgroundGrid = new Image("/res/backgroundGrid.png", 1024, 576, 0);
        background = new Image("/res/background.png", 1024, 576, 1);
        this.paused = true;
        gui = new Gui();
        tiles = new Tile[144];
        stats = JSONReader.parseJSOStats(FReader.read("data/stats.txt"));
        prices = JSONReader.parseJSONPrices((FReader.read("data/prices.txt")));
        level = JSONReader.parseJSONLevel(FReader.read("levels/testLevel.txt"));
        level.levelInit(tiles);
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        showGrid(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        gui.update(pc, level, passedTime);
        BuildMenu.update(pc, tiles, level.getTileId(), passedTime);
        if(paused == true)
        {
            if(stats.getHp() <= 0)
                return;
            level.update(pc, tiles, passedTime, stats);
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        //r.drawStaticImage(pc, backgroundGrid, 0, 0);
        r.drawStaticImage(pc, background, 0, 0);
        for(int i = 0; i < 144; i++)
        {
            r.drawImage(pc, tiles[i].getImg(), tiles[i].getPosX(), tiles[i].getPosY());
        }
        level.render(pc, r);
        for(int i = 0; i < 144; i++)
        {
            tiles[i].render(pc, r);
        }
        gui.render(pc, r, stats, level, passedTime);
        BuildMenu.render(pc, r, prices);
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

