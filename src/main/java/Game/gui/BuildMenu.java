package Game.gui;

import Game.Assets;
import Game.Stats;
import Map.Tile;
import Map.TowerPlace;
import Map.Towers.*;
import engine.*;

public class BuildMenu implements Clickable
{
    private static int id = -1;
    public static final Button MENU = new Button(Assets.BUILDMENU, -1000, -1000);
    public static final Button CLOSER = new Button(Assets.CLOSER, -1000, -1000);
    private static final Button FIRE = new Button(Assets.FIRE32, -1000, -1000);
    private static final Button AIR = new Button(Assets.AIR32, -1000, -1000);
    private static final Button WATER = new Button(Assets.WATER32, -1000, -1000);
    private static final Button EARTH = new Button(Assets.EARTH32, -1000, -1000);
    private static final Field FIREM = new Field(Assets.FIRE24, -1000, -1000);
    private static final Field AIRM = new Field(Assets.AIR24, -1000, -1000);
    private static final Field WATERM = new Field(Assets.WATER24, -1000, -1000);
    private static final Field EARTHM = new Field(Assets.EARTH24, -1000, -1000);
    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        AIR.setImg(Assets.AIRANIMA32.updateLoop(AIR.getImg(), World.tickCount));
        EARTH.setImg(Assets.EARTHANIMA32.updateLoop(EARTH.getImg(), World.tickCount));
        FIRE.setImg(Assets.FIREANIMA32.updateLoop(FIRE.getImg(), World.tickCount));
        WATER.setImg(Assets.WATERANIMA32.updateLoop(WATER.getImg(), World.tickCount));
        AIRM.setImg(Assets.AIRANIMA24.updateLoop(AIRM.getImg(), World.tickCount));
        EARTHM.setImg(Assets.EARTHANIMA24.updateLoop(EARTHM.getImg(), World.tickCount));
        FIREM.setImg(Assets.FIREANIMA24.updateLoop(FIREM.getImg(), World.tickCount));
        WATERM.setImg(Assets.WATERANIMA24.updateLoop(WATERM.getImg(), World.tickCount));
        if(CLOSER.isClick(pc, CLOSER.getPosX(), CLOSER.getPosY(), CLOSER.getImg().getW(), CLOSER.getImg().getH()))
        {
            close();
        }
        if((FIRE.isClick(pc, FIRE.getPosX(), FIRE.getPosY(), FIRE.getImg().getW(), FIRE.getImg().getH())) && (Stats.energy >= Stats.cost[0]))
        {
            close();
            Stats.energy -= Stats.cost[0];
            tileId[id] = 21;
            tiles[id] = new FireTower("FireTower",(id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 1, Stats.damage[0], Stats.range[0], Stats.fireDelay[0], ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
        if((AIR.isClick(pc, AIR.getPosX(), AIR.getPosY(), AIR.getImg().getW(), AIR.getImg().getH())) && (Stats.energy >= Stats.cost[1]))
        {
            close();
            Stats.energy -= Stats.cost[1];
            tileId[id] = 22;
            tiles[id] = new AirTower("AirTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 2, Stats.damage[1], Stats.range[1], Stats.fireDelay[1], ((TowerPlace)(tiles[id])).getTypePermission(), Stats.attackSpeedBoost[1], Stats.rangeBoost[1]);
        }
        if((WATER.isClick(pc, WATER.getPosX(), WATER.getPosY(), WATER.getImg().getW(), WATER.getImg().getH())) && (Stats.energy >= Stats.cost[2]))
        {
            close();
            Stats.energy -= Stats.cost[2];
            tileId[id] = 23;
            tiles[id] = new WaterTower("WaterTower", (id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 3, Stats.damage[2], Stats.range[2], Stats.fireDelay[2], ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
        if((EARTH.isClick(pc, EARTH.getPosX(), EARTH.getPosY(), EARTH.getImg().getW(), EARTH.getImg().getH())) && (Stats.energy >= Stats.cost[3]))
        {
            close();
            Stats.energy -= Stats.cost[3];
            tileId[id] = 24;
            tiles[id] = new EarthTower("EarthTower", (id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 4, Stats.damage[3], Stats.range[3], Stats.fireDelay[3], ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
    }
    public static void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, MENU.getImg(), (int)MENU.getPosX(), (int)MENU.getPosY());
        r.drawStaticImage(pc, CLOSER.getImg(), (int)CLOSER.getPosX(), (int)CLOSER.getPosY());
        r.drawStaticImage(pc, FIRE.getImg(), (int)FIRE.getPosX(), (int)FIRE.getPosY());
        r.drawStaticImage(pc, AIR.getImg(), (int)AIR.getPosX(), (int)AIR.getPosY());
        r.drawStaticImage(pc, WATER.getImg(), (int)WATER.getPosX(), (int)WATER.getPosY());
        r.drawStaticImage(pc, EARTH.getImg(), (int)EARTH.getPosX(), (int)EARTH.getPosY());
        r.drawStaticImage(pc, FIREM.getImg(), (int)FIREM.getPosX(), (int)FIREM.getPosY());
        r.drawStaticImage(pc, AIRM.getImg(), (int)AIRM.getPosX(), (int)AIRM.getPosY());
        r.drawStaticImage(pc, WATERM.getImg(), (int)WATERM.getPosX(), (int)WATERM.getPosY());
        r.drawStaticImage(pc, EARTHM.getImg(), (int)EARTHM.getPosX(), (int)EARTHM.getPosY());
        r.drawStaticText(pc, "" + Stats.cost[0], (int)FIRE.getPosX(), (int)FIRE.getPosY() + 20, 0xFFbcbcbc, 20);
        r.drawStaticText(pc, "" + Stats.cost[1], (int)AIR.getPosX(), (int)AIR.getPosY() + 20, 0xFFbcbcbc, 20);
        r.drawStaticText(pc, "" + Stats.cost[2], (int)WATER.getPosX(), (int)WATER.getPosY() + 20, 0xFFbcbcbc, 20);
        r.drawStaticText(pc, "" + Stats.cost[3], (int)EARTH.getPosX(), (int)EARTH.getPosY() + 20, 0xFFbcbcbc, 20);
    }
    public static void open(double posX, double posY, int iD, boolean[] typePermission)
    {
        id = iD;
        int x = 0;
        int y = 0;
        if((posY >= 192) && (posX >= 64) && (posX < 832))
        {
            x = -32;
            y = -140;
        }
        else if((posY >= 192) && (posX < 64))
        {
            x = 32;
            y = -140;
        }
        else if((posY >= 192) && (posY < 544) && (posX >= 832))
        {
            x = -140;
            y = 0;
        }
        else if((posY >= 544) && (posX >= 832))
        {
            x = -140;
            y = -96;
        }
        else if((posY < 192) && (posX >= 64) && (posX < 832))
        {
            x = -32;
            y = 86;
        }
        else if((posY < 192) && (posX < 64))
        {
            x = 32;
            y = 86;
        }
        else if((posY < 192) && (posX >= 832))
        {
            x = -140;
            y = 32;
        }
            MENU.setPosX(posX + x);
            MENU.setPosY(posY + y);
            if(typePermission[0] == true)
            {
                FIRE.setPosX(posX + x + 48);
                FIRE.setPosY(posY + y);
                FIREM.setPosX(posX + x + 3);
                FIREM.setPosY(posY + y + 3);
            }
            else
            {
                FIRE.setPosX(-1000);
                FIRE.setPosY(-1000);
                FIREM.setPosX(-1000);
                FIREM.setPosY(-1000);
            }
            if(typePermission[1] == true)
            {
                AIR.setPosX(posX + x + 4);
                AIR.setPosY(posY + y + 44);
                AIRM.setPosX(posX + x + 3);
                AIRM.setPosY(posY + y + 101);
            }
            else
            {
                AIR.setPosX(-1000);
                AIR.setPosY(-1000);
                AIRM.setPosX(-1000);
                AIRM.setPosY(-1000);
            }
            if(typePermission[2] == true)
            {
                WATER.setPosX(posX + x + 92);
                WATER.setPosY(posY + y + 44);
                WATERM.setPosX(posX + x + 98);
                WATERM.setPosY(posY + y);
            }
            else
            {
                WATER.setPosX(-1000);
                WATER.setPosY(-1000);
                WATERM.setPosX(-1000);
                WATERM.setPosY(-1000);
            }
            if(typePermission[3] == true)
            {
                EARTH.setPosX(posX + x + 48);
                EARTH.setPosY(posY + y + 88);
                EARTHM.setPosX(posX + x + 103);
                EARTHM.setPosY(posY + y + 96);
            }
            else
            {
                EARTH.setPosX(-1000);
                EARTH.setPosY(-1000);
                EARTHM.setPosX(-1000);
                EARTHM.setPosY(-1000);
            }
        CLOSER.setPosX(posX + x + 52);
        CLOSER.setPosY(posY + y + 52);
    }
    public static void close()
    {
        Input.justClicked = false;
        MENU.setPosX(-1000);
        MENU.setPosY(-1000);
        CLOSER.setPosX(-1000);
        CLOSER.setPosY(-1000);
        FIRE.setPosX(-1000);
        FIRE.setPosY(-1000);
        FIREM.setPosX(-1000);
        FIREM.setPosY(-1000);
        AIR.setPosX(-1000);
        AIR.setPosY(-1000);
        AIRM.setPosX(-1000);
        AIRM.setPosY(-1000);
        WATER.setPosX(-1000);
        WATER.setPosY(-1000);
        WATERM.setPosX(-1000);
        WATERM.setPosY(-1000);
        EARTH.setPosX(-1000);
        EARTH.setPosY(-1000);
        EARTHM.setPosX(-1000);
        EARTHM.setPosY(-1000);
    }

    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height) {

    }
}

