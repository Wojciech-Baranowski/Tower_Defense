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
    private static final Button[] EMBLEMS64 = {new Button(Assets.FIRE64, -1000, -1000), new Button(Assets.AIR64, -1000, -1000), new Button(Assets.WATER64, -1000, -1000), new Button(Assets.EARTH64, -1000, -1000)};
    private static final Field[] EMBLEMS24 = {new Field(Assets.FIRE24, -1000, -1000), new Field(Assets.AIR24, -1000, -1000), new Field(Assets.WATER24, -1000, -1000), new Field(Assets.EARTH24, -1000, -1000)};

    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        EMBLEMS64[0].setImg(Assets.FIREANIMA32.updateLoop(EMBLEMS64[0].getImg(), World.tickCount));
        EMBLEMS64[1].setImg(Assets.AIRANIMA32.updateLoop(EMBLEMS64[1].getImg(), World.tickCount));
        EMBLEMS64[2].setImg(Assets.WATERANIMA32.updateLoop(EMBLEMS64[2].getImg(), World.tickCount));
        EMBLEMS64[3].setImg(Assets.EARTHANIMA32.updateLoop(EMBLEMS64[3].getImg(), World.tickCount));

        EMBLEMS24[0].setImg(Assets.FIREANIMA24.updateLoop(EMBLEMS24[0].getImg(), World.tickCount));
        EMBLEMS24[1].setImg(Assets.AIRANIMA24.updateLoop(EMBLEMS24[1].getImg(), World.tickCount));
        EMBLEMS24[2].setImg(Assets.WATERANIMA24.updateLoop(EMBLEMS24[2].getImg(), World.tickCount));
        EMBLEMS24[3].setImg(Assets.EARTHANIMA24.updateLoop(EMBLEMS24[3].getImg(), World.tickCount));

        if(CLOSER.isClick(pc, CLOSER.getPosX(), CLOSER.getPosY(), CLOSER.getImg().getW(), CLOSER.getImg().getH()))
        {
            close();
        }
        if((EMBLEMS64[0].isClick(pc, EMBLEMS64[0].getPosX(), EMBLEMS64[0].getPosY(), EMBLEMS64[0].getImg().getW(), EMBLEMS64[0].getImg().getH())) && (Stats.energy >= Stats.cost[0]))
        {
            close();
            Stats.energy -= Stats.cost[0];
            tileId[id] = 21;
            tiles[id] = new FireTower("FireTower",(id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 1, Stats.damage[0], Stats.range[0], Stats.fireDelay[0], ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
        if((EMBLEMS64[1].isClick(pc, EMBLEMS64[1].getPosX(), EMBLEMS64[1].getPosY(), EMBLEMS64[1].getImg().getW(), EMBLEMS64[1].getImg().getH())) && (Stats.energy >= Stats.cost[1]))
        {
            close();
            Stats.energy -= Stats.cost[1];
            tileId[id] = 22;
            tiles[id] = new AirTower("AirTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 2, Stats.damage[1], Stats.range[1], Stats.fireDelay[1], ((TowerPlace)(tiles[id])).getTypePermission(), Stats.attackSpeedBoost[1], Stats.rangeBoost[1]);
        }
        if((EMBLEMS64[2].isClick(pc, EMBLEMS64[2].getPosX(), EMBLEMS64[2].getPosY(), EMBLEMS64[2].getImg().getW(), EMBLEMS64[2].getImg().getH())) && (Stats.energy >= Stats.cost[2]))
        {
            close();
            Stats.energy -= Stats.cost[2];
            tileId[id] = 23;
            tiles[id] = new WaterTower("WaterTower", (id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 3, Stats.damage[2], Stats.range[2], Stats.fireDelay[2], ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
        if((EMBLEMS64[3].isClick(pc, EMBLEMS64[3].getPosX(), EMBLEMS64[3].getPosY(), EMBLEMS64[3].getImg().getW(), EMBLEMS64[3].getImg().getH())) && (Stats.energy >= Stats.cost[3]))
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
        for(int i = 0 ; i < 4; i++)
        {
            r.drawStaticImage(pc, EMBLEMS64[i].getImg(), (int)EMBLEMS64[i].getPosX(), (int)EMBLEMS64[i].getPosY());
            r.drawStaticImage(pc, EMBLEMS24[i].getImg(), (int)EMBLEMS24[i].getPosX(), (int)EMBLEMS24[i].getPosY());
            r.drawStaticText(pc, "" + Stats.cost[0], (int)EMBLEMS64[i].getPosX(), (int)EMBLEMS64[i].getPosY() + 20, 0xFFbcbcbc, 20);
        }
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
                EMBLEMS64[0].setPosX(posX + x + 48);
                EMBLEMS64[0].setPosY(posY + y);
                EMBLEMS24[0].setPosX(posX + x + 3);
                EMBLEMS24[0].setPosY(posY + y + 3);
            }
            else
            {
                EMBLEMS64[0].setPosX(-1000);
                EMBLEMS64[0].setPosY(-1000);
                EMBLEMS24[0].setPosX(-1000);
                EMBLEMS24[0].setPosY(-1000);
            }
            if(typePermission[1] == true)
            {
                EMBLEMS64[1].setPosX(posX + x + 4);
                EMBLEMS64[1].setPosY(posY + y + 44);
                EMBLEMS24[1].setPosX(posX + x + 3);
                EMBLEMS24[1].setPosY(posY + y + 101);
            }
            else
            {
                EMBLEMS64[1].setPosX(-1000);
                EMBLEMS64[1].setPosY(-1000);
                EMBLEMS24[1].setPosX(-1000);
                EMBLEMS24[1].setPosY(-1000);
            }
            if(typePermission[2] == true)
            {
                EMBLEMS64[2].setPosX(posX + x + 92);
                EMBLEMS64[2].setPosY(posY + y + 44);
                EMBLEMS24[2].setPosX(posX + x + 98);
                EMBLEMS24[2].setPosY(posY + y);
            }
            else
            {
                EMBLEMS64[2].setPosX(-1000);
                EMBLEMS64[2].setPosY(-1000);
                EMBLEMS24[2].setPosX(-1000);
                EMBLEMS24[2].setPosY(-1000);
            }
            if(typePermission[3] == true)
            {
                EMBLEMS64[3].setPosX(posX + x + 48);
                EMBLEMS64[3].setPosY(posY + y + 88);
                EMBLEMS24[3].setPosX(posX + x + 103);
                EMBLEMS24[3].setPosY(posY + y + 96);
            }
            else
            {
                EMBLEMS64[3].setPosX(-1000);
                EMBLEMS64[3].setPosY(-1000);
                EMBLEMS24[3].setPosX(-1000);
                EMBLEMS24[3].setPosY(-1000);
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
        for(int i = 0; i < 4; i++)
        {
            EMBLEMS64[i].setPosX(-1000);
            EMBLEMS64[i].setPosY(-1000);
            EMBLEMS24[i].setPosX(-1000);
            EMBLEMS24[i].setPosY(-1000);
        }
    }

    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height) {

    }
}

