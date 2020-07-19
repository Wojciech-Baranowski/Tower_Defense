package Game.gui;
import Game.Assets;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import Map.Towers.*;
import engine.*;

public class BasicUpgradeMenu
{
    private static int id = -1;
    private static int towerId = -1;
    public static final Button MENU = new Button(Assets.BASICUPGRADEMENU, -1000, -1000);
    public static final Button CLOSER = new Button(Assets.CLOSER, -1000, -1000);
    public static final Button UPGRADEBUTTON = new Button(Assets.UPGRADEBUTTON64, -1000, -1000);
    private static final Field[] EMBLEMS64 = {new Field(Assets.FIRE64, -1000, -1000), new Field(Assets.AIR64, -1000, -1000), new Field(Assets.WATER64, -1000, -1000), new Field(Assets.EARTH64, -1000, -1000)};
    private static final Field[] EMBLEMS24 = {new Field(Assets.FIRE24, -1000, -1000), new Field(Assets.AIR24, -1000, -1000), new Field(Assets.WATER24, -1000, -1000), new Field(Assets.EARTH24, -1000, -1000)};
    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        EMBLEMS64[0].setImg(Assets.FIREANIMA64.updateLoop(EMBLEMS64[0].getImg(), World.tickCount));
        EMBLEMS64[1].setImg(Assets.AIRANIMA64.updateLoop(EMBLEMS64[1].getImg(), World.tickCount));
        EMBLEMS64[2].setImg(Assets.WATERANIMA64.updateLoop(EMBLEMS64[2].getImg(), World.tickCount));
        EMBLEMS64[3].setImg(Assets.EARTHANIMA64.updateLoop(EMBLEMS64[3].getImg(), World.tickCount));

        EMBLEMS24[0].setImg(Assets.FIREANIMA24.updateLoop(EMBLEMS24[0].getImg(), World.tickCount));
        EMBLEMS24[1].setImg(Assets.AIRANIMA24.updateLoop(EMBLEMS24[1].getImg(), World.tickCount));
        EMBLEMS24[2].setImg(Assets.WATERANIMA24.updateLoop(EMBLEMS24[2].getImg(), World.tickCount));
        EMBLEMS24[3].setImg(Assets.EARTHANIMA24.updateLoop(EMBLEMS24[3].getImg(), World.tickCount));

        if(CLOSER.isClick(pc, CLOSER.getPosX(), CLOSER.getPosY(), CLOSER.getImg().getW(), CLOSER.getImg().getH()))
        {
            close();
        }
        if(UPGRADEBUTTON.isClick(pc, UPGRADEBUTTON.getPosX(), UPGRADEBUTTON.getPosY(), UPGRADEBUTTON.getImg().getW(), UPGRADEBUTTON.getImg().getH()))
        {
            if((towerId == 1) && (Stats.energy >= Stats.cost[4]))
            {
                close();
                Stats.energy -= Stats.cost[4];
                tileId[id] = 211;
                tiles[id] = new AdvancedFireTower("AdvancedFireTower",(id % 16) * 64, (id / 16) * 64, id, 2, passedTime, 11, Stats.damage[4], Stats.range[4], Stats.fireDelay[4], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if((towerId == 2) && (Stats.energy >= Stats.cost[5]))
            {
                close();
                Stats.energy -= Stats.cost[5];
                tileId[id] = 212;
                tiles[id] = new AdvancedAirTower("AdvancedAirTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 2, passedTime, 12, Stats.damage[5], Stats.range[5], Stats.fireDelay[5], ((Tower)(tiles[id])).getTypePermission(), Stats.attackSpeedBoost[5], Stats.rangeBoost[1]);
            }
            else if((towerId == 3) && (Stats.energy >= Stats.cost[6]))
            {
                close();
                Stats.energy -= Stats.cost[6];
                tileId[id] = 213;
                tiles[id] = new AdvancedWaterTower("AdvancedWaterTower", (id % 16) * 64, (id / 16) * 64, id, 2, passedTime, 13, Stats.damage[6], Stats.range[6], Stats.fireDelay[6], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if((towerId == 4) && (Stats.energy >= Stats.cost[7]))
            {
                close();
                Stats.energy -= Stats.cost[7];
                tileId[id] = 214;
                tiles[id] = new AdvancedEarthTower("AdvancedEarthTower", (id % 16) * 64, (id / 16) * 64, id, 2, passedTime, 14, Stats.damage[7], Stats.range[7], Stats.fireDelay[7], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
        }
    }
    public static void open(double posX, double posY, int iD, int towerID, boolean[] typePermission)
    {
        close();
        id = iD;
        towerId = towerID;
        int x = 0;
        int y = 0;
        if((posY >= 192) && (posX >= 64) && (posX < 832))
        {
            x = -32;
            y = -108;
        }
        else if((posY >= 192) && (posX < 64))
        {
            x = 32;
            y = -108;
        }
        else if((posY >= 192) && (posY < 544) && (posX >= 832))
        {
            x = -140;
            y = 0;
        }
        else if((posY >= 544) && (posX >= 832))
        {
            x = -140;
            y = -64;
        }
        else if((posY < 192) && (posX >= 64) && (posX < 832))
        {
            x = -32;
            y = 118;
        }
        else if((posY < 192) && (posX < 64))
        {
            x = 32;
            y = 118;
        }
        else if((posY < 192) && (posX >= 832))
        {
            x = -140;
            y = 64;
        }
        MENU.setPosX(posX + x);
        MENU.setPosY(posY + y);
        UPGRADEBUTTON.setPosX(posX + x + 32);
        UPGRADEBUTTON.setPosY(posY + y);
        if(typePermission[0] == true)
        {
            EMBLEMS24[0].setPosX(posX + x);
            EMBLEMS24[0].setPosY(posY + y + 3);
        }
        else
        {
            EMBLEMS24[0].setPosX(-1000);
            EMBLEMS24[0].setPosY(-1000);
        }
        if(typePermission[1] == true)
        {
            EMBLEMS24[1].setPosX(posX + x + 3);
            EMBLEMS24[1].setPosY(posY + y + 101);
        }
        else
        {
            EMBLEMS24[1].setPosX(-1000);
            EMBLEMS24[1].setPosY(-1000);
        }
        if(typePermission[2] == true)
        {
            EMBLEMS24[2].setPosX(posX + x + 98);
            EMBLEMS24[2].setPosY(posY + y);
        }
        else
        {
            EMBLEMS24[2].setPosX(-1000);
            EMBLEMS24[2].setPosY(-1000);
        }
        if(typePermission[3] == true)
        {
            EMBLEMS24[3].setPosX(posX + x + 103);
            EMBLEMS24[3].setPosY(posY + y + 96);
        }
        else
        {
            EMBLEMS24[3].setPosX(-1000);
            EMBLEMS24[3].setPosY(-1000);
        }
        for(int i = 0; i < 4; i++)
        {
            if(towerId == i + 1)
            {
                EMBLEMS64[i].setPosX(posX + x + 32);
                EMBLEMS64[i].setPosY(posY + y);
            }
        }
        CLOSER.setPosX(posX + x + 52);
        CLOSER.setPosY(posY + y + 99);
    }
    public static void close()
    {
        Input.justClicked = false;
        MENU.setPosX(-1000);
        MENU.setPosY(-1000);
        CLOSER.setPosX(-1000);
        CLOSER.setPosY(-1000);
        UPGRADEBUTTON.setPosX(-1000);
        UPGRADEBUTTON.setPosY(-1000);
        for(int i = 0; i < 4; i++)
        {
            EMBLEMS24[i].setPosX(-1000);
            EMBLEMS24[i].setPosY(-1000);
            EMBLEMS64[i].setPosX(-1000);
            EMBLEMS64[i].setPosY(-1000);
        }
    }
    public static void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, MENU.getImg(), (int)MENU.getPosX(), (int)MENU.getPosY());
        r.drawStaticImage(pc, CLOSER.getImg(), (int)CLOSER.getPosX(), (int)CLOSER.getPosY());
        r.drawStaticText(pc, "" + Stats.cost[towerId + 3], (int)MENU.getPosX() + 48, (int)MENU.getPosY() + 62, 0xFFbcbcbc, 20);
        for(int i = 0; i < 4; i++)
        {
            r.drawStaticImage(pc, EMBLEMS24[i].getImg(), (int)EMBLEMS24[i].getPosX(), (int)EMBLEMS24[i].getPosY());
            r.drawStaticImage(pc, EMBLEMS64[i].getImg(), (int)EMBLEMS64[i].getPosX(), (int)EMBLEMS64[i].getPosY());
        }
        r.drawStaticImage(pc, UPGRADEBUTTON.getImg(), (int)UPGRADEBUTTON.getPosX(), (int)UPGRADEBUTTON.getPosY());
    }
}

