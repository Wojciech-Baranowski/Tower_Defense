package Game.gui;
import Game.Assets;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import Map.Towers.*;
import engine.*;

public class AdvancedUpgradeMenu
{
    private static int id = -1;
    private static int towerId = -1;
    public static final Button MENU = new Button(Assets.ADVANCEDUPGRADEMENU, -1000, -1000);
    public static final Button CLOSER = new Button(Assets.CLOSER, -1000, -1000);
    public static final Button UPGRADEBUTTON1 = new Button(Assets.UPGRADEBUTTON48, -1000, -1000);
    public static final Button UPGRADEBUTTON2 = new Button(Assets.UPGRADEBUTTON48, -1000, -1000);
    public static final Button UPGRADEBUTTON3 = new Button(Assets.UPGRADEBUTTON48, -1000, -1000);
    private static final Field[] EMBLEMS40L = {new Field(Assets.FIRE40, -1000, -1000), new Field(Assets.AIR40, -1000, -1000), new Field(Assets.WATER40, -1000, -1000), new Field(Assets.EARTH40, -1000, -1000)};
    private static final Field[] EMBLEMS40M = {new Field(Assets.FIRE40, -1000, -1000), new Field(Assets.AIR40, -1000, -1000), new Field(Assets.WATER40, -1000, -1000), new Field(Assets.EARTH40, -1000, -1000)};
    private static final Field[] EMBLEMS40R = {new Field(Assets.FIRE40, -1000, -1000), new Field(Assets.AIR40, -1000, -1000), new Field(Assets.WATER40, -1000, -1000), new Field(Assets.EARTH40, -1000, -1000)};
    private static final Field[] EMBLEMS24 = {new Field(Assets.FIRE24, -1000, -1000), new Field(Assets.AIR24, -1000, -1000), new Field(Assets.WATER24, -1000, -1000), new Field(Assets.EARTH24, -1000, -1000)};
    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        EMBLEMS24[0].setImg(Assets.FIREANIMA24.updateLoop(EMBLEMS24[0].getImg(), World.tickCount));
        EMBLEMS24[1].setImg(Assets.AIRANIMA24.updateLoop(EMBLEMS24[1].getImg(), World.tickCount));
        EMBLEMS24[2].setImg(Assets.WATERANIMA24.updateLoop(EMBLEMS24[2].getImg(), World.tickCount));
        EMBLEMS24[3].setImg(Assets.EARTHANIMA24.updateLoop(EMBLEMS24[3].getImg(), World.tickCount));

        EMBLEMS40L[0].setImg(Assets.FIREANIMA40.updateLoop(EMBLEMS40L[0].getImg(), World.tickCount));
        EMBLEMS40L[1].setImg(Assets.AIRANIMA40.updateLoop(EMBLEMS40L[1].getImg(), World.tickCount));
        EMBLEMS40L[2].setImg(Assets.WATERANIMA40.updateLoop(EMBLEMS40L[2].getImg(), World.tickCount));
        EMBLEMS40L[3].setImg(Assets.EARTHANIMA40.updateLoop(EMBLEMS40L[3].getImg(), World.tickCount));

        EMBLEMS40M[0].setImg(Assets.FIREANIMA40.updateLoop(EMBLEMS40M[0].getImg(), World.tickCount));
        EMBLEMS40M[1].setImg(Assets.AIRANIMA40.updateLoop(EMBLEMS40M[1].getImg(), World.tickCount));
        EMBLEMS40M[2].setImg(Assets.WATERANIMA40.updateLoop(EMBLEMS40M[2].getImg(), World.tickCount));
        EMBLEMS40M[3].setImg(Assets.EARTHANIMA40.updateLoop(EMBLEMS40M[3].getImg(), World.tickCount));

        EMBLEMS40R[0].setImg(Assets.FIREANIMA40.updateLoop(EMBLEMS40R[0].getImg(), World.tickCount));
        EMBLEMS40R[1].setImg(Assets.AIRANIMA40.updateLoop(EMBLEMS40R[1].getImg(), World.tickCount));
        EMBLEMS40R[2].setImg(Assets.WATERANIMA40.updateLoop(EMBLEMS40R[2].getImg(), World.tickCount));
        EMBLEMS40R[3].setImg(Assets.EARTHANIMA40.updateLoop(EMBLEMS40R[3].getImg(), World.tickCount));

        if(CLOSER.isClick(pc, CLOSER.getPosX(), CLOSER.getPosY(), CLOSER.getImg().getW(), CLOSER.getImg().getH()))
        {
            close();
        }
        if(UPGRADEBUTTON1.isClick(pc, UPGRADEBUTTON1.getPosX(), UPGRADEBUTTON1.getPosY(), UPGRADEBUTTON1.getImg().getW(), UPGRADEBUTTON1.getImg().getH()))
        {
            if(((towerId == 11) || (towerId == 12)) && (Stats.energy >= Stats.cost[12]))
            {
                close();
                Stats.energy -= Stats.cost[12];
                tileId[id] = 235;
                tiles[id] = new LightingTower("LightingTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 25, Stats.damage[12], Stats.range[12], Stats.fireDelay[12], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if(((towerId == 13) || (towerId == 14)) && (Stats.energy >= Stats.cost[15]))
            {
                close();
                Stats.energy -= Stats.cost[15];
                tileId[id] = 238;
                tiles[id] = new LeafTower("LeafTower", (id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 28, Stats.damage[15], Stats.range[15], Stats.fireDelay[15], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
        }
        if(UPGRADEBUTTON2.isClick(pc, UPGRADEBUTTON2.getPosX(), UPGRADEBUTTON2.getPosY(), UPGRADEBUTTON2.getImg().getW(), UPGRADEBUTTON2.getImg().getH()))
        {
            if((towerId == 11) && (Stats.energy >= Stats.cost[8]))
            {
                close();
                Stats.energy -= Stats.cost[8];
                tileId[id] = 221;
                tiles[id] = new MasterFireTower("MasterFireTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 21, Stats.damage[8], Stats.range[8], Stats.fireDelay[8], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if((towerId == 12) && (Stats.energy >= Stats.cost[9]))
            {
                close();
                Stats.energy -= Stats.cost[9];
                tileId[id] = 222;
                tiles[id] = new MasterAirTower("MasterAirTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 22, Stats.damage[9], Stats.range[9], Stats.fireDelay[9], ((Tower)(tiles[id])).getTypePermission(), Stats.attackSpeedBoost[9], Stats.rangeBoost[9], Stats.damageBoost[9]);
            }
            else if((towerId == 13) && (Stats.energy >= Stats.cost[10]))
            {
                close();
                Stats.energy -= Stats.cost[10];
                tileId[id] = 223;
                tiles[id] = new MasterWaterTower("MasterWaterTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 23, Stats.damage[10], Stats.range[10], Stats.fireDelay[10], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if((towerId == 14) && (Stats.energy >= Stats.cost[11]))
            {
                close();
                Stats.energy -= Stats.cost[11];
                tileId[id] = 224;
                tiles[id] = new MasterEarthTower("MasterEarthTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 24, Stats.damage[11], Stats.range[11], Stats.fireDelay[11], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
        }
        if(UPGRADEBUTTON3.isClick(pc, UPGRADEBUTTON3.getPosX(), UPGRADEBUTTON3.getPosY(), UPGRADEBUTTON3.getImg().getW(), UPGRADEBUTTON3.getImg().getH()))
        {
            if(((towerId == 11) || (towerId == 14)) && (Stats.energy >= Stats.cost[13]))
            {
                close();
                Stats.energy -= Stats.cost[13];
                tileId[id] = 226;
                tiles[id] = new MagmaTower("MagmaTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 26, Stats.damage[13], Stats.range[13], Stats.fireDelay[13], ((Tower)(tiles[id])).getTypePermission());
            }
            else if(((towerId == 12) || (towerId == 13)) && (Stats.energy >= Stats.cost[14]))
            {
                close();
                Stats.energy -= Stats.cost[14];
                Stats.energy -= Stats.cost[14];
                tileId[id] = 227;
                tiles[id] = new IceTower("IceTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 27, Stats.damage[14], Stats.range[14], Stats.fireDelay[14], ((Tower)(tiles[id])).getTypePermission());
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
            x = -80;
            y = -108;
        }
        else if((posY >= 192) && (posX < 64))
        {
            x = 32;
            y = -108;
        }
        else if((posY >= 192) && (posY < 544) && (posX >= 832))
        {
            x = -230;
            y = 0;
        }
        else if((posY >= 544) && (posX >= 832))
        {
            x = -230;
            y = -64;
        }
        else if((posY < 192) && (posX >= 64) && (posX < 832))
        {
            x = -80;
            y = 118;
        }
        else if((posY < 192) && (posX < 64))
        {
            x = 32;
            y = 118;
        }
        else if((posY < 192) && (posX >= 832))
        {
            x = -230;
            y = 64;
        }
        MENU.setPosX(posX + x);
        MENU.setPosY(posY + y);
        UPGRADEBUTTON1.setPosX(posX + x);
        UPGRADEBUTTON1.setPosY(posY + y + 40);
        UPGRADEBUTTON2.setPosX(posX + x + 40);
        UPGRADEBUTTON2.setPosY(posY + y);
        UPGRADEBUTTON3.setPosX(posX + x + 80);
        UPGRADEBUTTON3.setPosY(posY + y + 40);
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
        if(towerId == 11)
        {
            EMBLEMS40L[1].setPosX(posX + x + 4);
            EMBLEMS40L[1].setPosY(posY + y + 40);
            EMBLEMS40M[0].setPosX(posX + x + 44);
            EMBLEMS40M[0].setPosY(posY + y);
            EMBLEMS40R[3].setPosX(posX + x + 84);
            EMBLEMS40R[3].setPosY(posY + y + 40);
        }
        else if(towerId == 12)
        {
            EMBLEMS40L[0].setPosX(posX + x + 4);
            EMBLEMS40L[0].setPosY(posY + y + 40);
            EMBLEMS40M[1].setPosX(posX + x + 44);
            EMBLEMS40M[1].setPosY(posY + y);
            EMBLEMS40R[2].setPosX(posX + x + 84);
            EMBLEMS40R[2].setPosY(posY + y + 40);
        }
        else if(towerId == 13)
        {
            EMBLEMS40L[3].setPosX(posX + x + 4);
            EMBLEMS40L[3].setPosY(posY + y + 40);
            EMBLEMS40M[2].setPosX(posX + x + 44);
            EMBLEMS40M[2].setPosY(posY + y);
            EMBLEMS40R[1].setPosX(posX + x + 84);
            EMBLEMS40R[1].setPosY(posY + y + 40);
        }
        else if(towerId == 14)
        {
            EMBLEMS40L[2].setPosX(posX + x + 4);
            EMBLEMS40L[2].setPosY(posY + y + 40);
            EMBLEMS40M[3].setPosX(posX + x + 44);
            EMBLEMS40M[3].setPosY(posY + y);
            EMBLEMS40R[0].setPosX(posX + x + 84);
            EMBLEMS40R[0].setPosY(posY + y + 40);
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
        UPGRADEBUTTON1.setPosX(-1000);
        UPGRADEBUTTON1.setPosY(-1000);
        UPGRADEBUTTON2.setPosX(-1000);
        UPGRADEBUTTON2.setPosY(-1000);
        UPGRADEBUTTON3.setPosX(-1000);
        UPGRADEBUTTON3.setPosY(-1000);
        for(int i = 0; i < 4; i++)
        {
            EMBLEMS24[i].setPosX(-1000);
            EMBLEMS24[i].setPosY(-1000);
            EMBLEMS40L[i].setPosX(-1000);
            EMBLEMS40L[i].setPosY(-1000);
            EMBLEMS40M[i].setPosX(-1000);
            EMBLEMS40M[i].setPosY(-1000);
            EMBLEMS40R[i].setPosX(-1000);
            EMBLEMS40R[i].setPosY(-1000);
        }
    }
    public static void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, MENU.getImg(), (int)MENU.getPosX(), (int)MENU.getPosY());
        r.drawStaticImage(pc, CLOSER.getImg(), (int)CLOSER.getPosX(), (int)CLOSER.getPosY());
        if(towerId > 10)
            r.drawStaticImage(pc, EMBLEMS40M[towerId - 11].getImg(), (int)EMBLEMS40M[towerId - 11].getPosX(), (int)EMBLEMS40M[towerId - 11].getPosY());
        if(towerId == 11)
        {
            r.drawStaticImage(pc, EMBLEMS40L[1].getImg(), (int)EMBLEMS40L[1].getPosX(), (int)EMBLEMS40L[1].getPosY());
            r.drawStaticImage(pc, EMBLEMS40R[3].getImg(), (int)EMBLEMS40R[3].getPosX(), (int)EMBLEMS40R[3].getPosY());
        }
        if(towerId == 12)
        {
            r.drawStaticImage(pc, EMBLEMS40L[0].getImg(), (int)EMBLEMS40L[0].getPosX(), (int)EMBLEMS40L[0].getPosY());
            r.drawStaticImage(pc, EMBLEMS40R[2].getImg(), (int)EMBLEMS40R[2].getPosX(), (int)EMBLEMS40R[2].getPosY());
        }
        if(towerId == 13)
        {
            r.drawStaticImage(pc, EMBLEMS40L[3].getImg(), (int)EMBLEMS40L[3].getPosX(), (int)EMBLEMS40L[3].getPosY());
            r.drawStaticImage(pc, EMBLEMS40R[1].getImg(), (int)EMBLEMS40R[1].getPosX(), (int)EMBLEMS40R[1].getPosY());
        }
        if(towerId == 14)
        {
            r.drawStaticImage(pc, EMBLEMS40L[2].getImg(), (int)EMBLEMS40L[2].getPosX(), (int)EMBLEMS40L[2].getPosY());
            r.drawStaticImage(pc, EMBLEMS40R[0].getImg(), (int)EMBLEMS40R[0].getPosX(), (int)EMBLEMS40R[0].getPosY());
        }
        r.drawStaticImage(pc, UPGRADEBUTTON1.getImg(), (int)UPGRADEBUTTON1.getPosX(), (int)UPGRADEBUTTON1.getPosY());
        r.drawStaticImage(pc, UPGRADEBUTTON2.getImg(), (int)UPGRADEBUTTON2.getPosX(), (int)UPGRADEBUTTON2.getPosY());
        r.drawStaticImage(pc, UPGRADEBUTTON3.getImg(), (int)UPGRADEBUTTON3.getPosX(), (int)UPGRADEBUTTON3.getPosY());
        if(towerId > 10)
            r.drawStaticText(pc, "" + Stats.cost[towerId - 3], (int)MENU.getPosX() + 48, (int)MENU.getPosY() + 24, 0xFFbcbcbc, 20);
        if((towerId == 11) || (towerId == 12))
            r.drawStaticText(pc, "" + Stats.cost[12], (int)MENU.getPosX() + 8, (int)MENU.getPosY() + 64, 0xFFbcbcbc, 20);
        if((towerId == 13) || (towerId == 14))
            r.drawStaticText(pc, "" + Stats.cost[15], (int)MENU.getPosX() + 8, (int)MENU.getPosY() + 64, 0xFFbcbcbc, 20);
        if((towerId == 11) || (towerId == 14))
            r.drawStaticText(pc, "" + Stats.cost[13], (int)MENU.getPosX() + 88, (int)MENU.getPosY() + 64, 0xFFbcbcbc, 20);
        if((towerId == 12) || (towerId == 13))
            r.drawStaticText(pc, "" + Stats.cost[14], (int)MENU.getPosX() + 88, (int)MENU.getPosY() + 64, 0xFFbcbcbc, 20);
        for(int i = 0; i < 4; i++)
            r.drawStaticImage(pc, EMBLEMS24[i].getImg(), (int)EMBLEMS24[i].getPosX(), (int)EMBLEMS24[i].getPosY());
    }
}

