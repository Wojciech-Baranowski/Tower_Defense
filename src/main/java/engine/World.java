package engine;

import Game.*;
import Game.gui.Gui;
import Map.Tile;

import java.awt.event.KeyEvent;

public class World
{
    private double deltaTime;
    private double passedTime = 0;
    public static long tickCount = 0;
    private boolean paused;
    private Image background;
    private Field canvas;

    private Level level;
    private Tile[] tiles;
    private Stats stats;
    private Prices prices;
    public final static String zer0 = "Mateusz, sam jestes leb xD";
    public World(ProgramContainer pc)
    {
        background = Assets.BACKGROUND;
        this.paused = true;
        tiles = new Tile[144];
        stats = JSONReader.parseJSOStats(FReader.read("data/stats.txt"));
        prices = JSONReader.parseJSONPrices((FReader.read("data/prices.txt")));
        level = JSONReader.parseJSONLevel(FReader.read("levels/testLevel.txt"));
        level.levelInit(tiles);
        canvas = new Field(new Image("/canvas.png", 1024, 576, 0), 0, 0);
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        Gui.update(pc, level, passedTime, tiles);
        if((paused == true) && (stats.getHp() > 0))
        {
            level.update(pc, tiles, passedTime);
        }
        Input.isHolding(pc);
        tickCount++;
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, background, 0, 0);
        level.render(pc, r, tiles);
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

