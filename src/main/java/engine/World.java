package engine;

import Game.*;
import Game.gui.BasicUpgradeMenu;
import Game.gui.BuildMenu;
import Game.gui.Gui;
import Map.Tile;

import java.awt.event.KeyEvent;

import static engine.Animation.ANIMA1;

public class World
{
    private double deltaTime;
    private double passedTime = 0;
    private static long tickCount = 0;
    private boolean paused;
    private Image background;

    private Level level;
    private Tile[] tiles;
    private Stats stats;
    private Prices prices;
    private Field test;
    public final static String zer0 = "Mateusz, sam jestes leb xD";
    public World(ProgramContainer pc)
    {
        background = new Image("/res/background.png", 1024, 576, 1);
        this.paused = true;
        tiles = new Tile[144];
        stats = JSONReader.parseJSOStats(FReader.read("data/stats.txt"));
        prices = JSONReader.parseJSONPrices((FReader.read("data/prices.txt")));
        level = JSONReader.parseJSONLevel(FReader.read("levels/testLevel.txt"));
        level.levelInit(tiles);
        test = new Field("/res/1.png", 100, 100, 64, 64, 0);
    }

    public void update(ProgramContainer pc, double currentTime)
    {
        pause(pc);
        deltaTime = (currentTime - passedTime) * 60;
        passedTime = currentTime;
        Gui.update(pc, level, passedTime);
        BuildMenu.update(pc, tiles, passedTime, level.getTileId());
        BasicUpgradeMenu.update(pc, tiles, passedTime, level.getTileId());
        test.setImg(ANIMA1.update(test.getImg(), tickCount));
        if((paused == true) && (stats.getHp() > 0))
        {
            level.update(pc, tiles, passedTime);
        }
        if(tickCount % 18 == 0)
            test.setImg(ANIMA1.animate());
        Input.isHolding(pc);
        tickCount++;
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, background, 0, 0);
        level.render(pc, r, tiles);
        Gui.render(pc, r, stats, level, passedTime);
        r.drawImage(pc, test.getImg(), (int)test.getPosX(), (int)test.getPosY());
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

