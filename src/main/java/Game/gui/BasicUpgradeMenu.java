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
    private static final Field FIREM = new Field(Assets.FIRE24, -1000, -1000);
    private static final Field AIRM = new Field(Assets.AIR24, -1000, -1000);
    private static final Field WATERM = new Field(Assets.WATER24, -1000, -1000);
    private static final Field EARTHM = new Field(Assets.EARTH24, -1000, -1000);
    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        AIRM.setImg(Assets.AIRANIMA24.updateLoop(AIRM.getImg(), World.tickCount));
        EARTHM.setImg(Assets.EARTHANIMA24.updateLoop(EARTHM.getImg(), World.tickCount));
        FIREM.setImg(Assets.FIREANIMA24.updateLoop(FIREM.getImg(), World.tickCount));
        WATERM.setImg(Assets.WATERANIMA24.updateLoop(WATERM.getImg(), World.tickCount));
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
            FIREM.setPosX(posX + x);
            FIREM.setPosY(posY + y + 3);
        }
        else
        {
            FIREM.setPosX(-1000);
            FIREM.setPosY(-1000);
        }
        if(typePermission[1] == true)
        {
            AIRM.setPosX(posX + x + 3);
            AIRM.setPosY(posY + y + 101);
        }
        else
        {
            AIRM.setPosX(-1000);
            AIRM.setPosY(-1000);
        }
        if(typePermission[2] == true)
        {
            WATERM.setPosX(posX + x + 98);
            WATERM.setPosY(posY + y);
        }
        else
        {
            WATERM.setPosX(-1000);
            WATERM.setPosY(-1000);
        }
        if(typePermission[3] == true)
        {
            EARTHM.setPosX(posX + x + 103);
            EARTHM.setPosY(posY + y + 96);
        }
        else
        {
            EARTHM.setPosX(-1000);
            EARTHM.setPosY(-1000);
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
        FIREM.setPosX(-1000);
        FIREM.setPosY(-1000);
        AIRM.setPosX(-1000);
        AIRM.setPosY(-1000);
        WATERM.setPosX(-1000);
        WATERM.setPosY(-1000);
        EARTHM.setPosX(-1000);
        EARTHM.setPosY(-1000);
    }
    public static void render(ProgramContainer pc, Renderer r)
    {
        System.out.println(towerId);
        r.drawStaticImage(pc, MENU.getImg(), (int)MENU.getPosX(), (int)MENU.getPosY());
        r.drawStaticImage(pc, CLOSER.getImg(), (int)CLOSER.getPosX(), (int)CLOSER.getPosY());
        r.drawStaticImage(pc, UPGRADEBUTTON.getImg(), (int)UPGRADEBUTTON.getPosX(), (int)UPGRADEBUTTON.getPosY());
        r.drawStaticText(pc, "" + Stats.cost[towerId + 3], (int)MENU.getPosX() + 48, (int)MENU.getPosY() + 62, 0xFFbcbcbc, 20);
        r.drawStaticImage(pc, FIREM.getImg(), (int)FIREM.getPosX(), (int)FIREM.getPosY());
        r.drawStaticImage(pc, AIRM.getImg(), (int)AIRM.getPosX(), (int)AIRM.getPosY());
        r.drawStaticImage(pc, WATERM.getImg(), (int)WATERM.getPosX(), (int)WATERM.getPosY());
        r.drawStaticImage(pc, EARTHM.getImg(), (int)EARTHM.getPosX(), (int)EARTHM.getPosY());
    }
}

