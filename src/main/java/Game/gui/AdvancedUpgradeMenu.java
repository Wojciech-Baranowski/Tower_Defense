package Game.gui;
import Game.Assets;
import Game.Prices;
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
    private static final Button FIRE1 = new Button(Assets.FIRE32, -1000, -1000);
    private static final Button FIRE2 = new Button(Assets.FIRE32, -1000, -1000);
    private static final Button FIRE3 = new Button(Assets.FIRE32, -1000, -1000);
    private static final Button AIR1 = new Button(Assets.AIR32, -1000, -1000);
    private static final Button AIR2 = new Button(Assets.AIR32, -1000, -1000);
    private static final Button AIR3 = new Button(Assets.AIR32, -1000, -1000);
    private static final Button WATER1 = new Button(Assets.WATER32, -1000, -1000);
    private static final Button WATER2 = new Button(Assets.WATER32, -1000, -1000);
    private static final Button WATER3 = new Button(Assets.WATER32, -1000, -1000);
    private static final Button EARTH1 = new Button(Assets.EARTH32, -1000, -1000);
    private static final Button EARTH2 = new Button(Assets.EARTH32, -1000, -1000);
    private static final Button EARTH3 = new Button(Assets.EARTH32, -1000, -1000);
    private static final Field FIREM = new Field(Assets.FIRE32, -1000, -1000);
    private static final Field AIRM = new Field(Assets.AIR32, -1000, -1000);
    private static final Field WATERM = new Field(Assets.WATER32, -1000, -1000);
    private static final Field EARTHM = new Field(Assets.EARTH32, -1000, -1000);
    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        AIR1.setImg(Assets.AIRANIMA32.updateLoop(AIR1.getImg(), World.tickCount));
        EARTH1.setImg(Assets.EARTHANIMA32.updateLoop(EARTH1.getImg(), World.tickCount));
        FIRE1.setImg(Assets.FIREANIMA32.updateLoop(FIRE1.getImg(), World.tickCount));
        WATER1.setImg(Assets.WATERANIMA32.updateLoop(WATER1.getImg(), World.tickCount));
        AIR2.setImg(Assets.AIRANIMA32.updateLoop(AIR2.getImg(), World.tickCount));
        EARTH2.setImg(Assets.EARTHANIMA32.updateLoop(EARTH2.getImg(), World.tickCount));
        FIRE2.setImg(Assets.FIREANIMA32.updateLoop(FIRE2.getImg(), World.tickCount));
        WATER2.setImg(Assets.WATERANIMA32.updateLoop(WATER2.getImg(), World.tickCount));
        AIR3.setImg(Assets.AIRANIMA32.updateLoop(AIR3.getImg(), World.tickCount));
        EARTH3.setImg(Assets.EARTHANIMA32.updateLoop(EARTH3.getImg(), World.tickCount));
        FIRE3.setImg(Assets.FIREANIMA32.updateLoop(FIRE3.getImg(), World.tickCount));
        WATER3.setImg(Assets.WATERANIMA32.updateLoop(WATER3.getImg(), World.tickCount));
        AIRM.setImg(Assets.AIRANIMA32.updateLoop(AIRM.getImg(), World.tickCount));
        EARTHM.setImg(Assets.EARTHANIMA32.updateLoop(EARTHM.getImg(), World.tickCount));
        FIREM.setImg(Assets.FIREANIMA32.updateLoop(FIREM.getImg(), World.tickCount));
        WATERM.setImg(Assets.WATERANIMA32.updateLoop(WATERM.getImg(), World.tickCount));
        if(CLOSER.isClick(pc, CLOSER.getPosX(), CLOSER.getPosY(), CLOSER.getImg().getW(), CLOSER.getImg().getH()))
        {
            close();
        }
        if(UPGRADEBUTTON1.isClick(pc, UPGRADEBUTTON1.getPosX(), UPGRADEBUTTON1.getPosY(), UPGRADEBUTTON1.getImg().getW(), UPGRADEBUTTON1.getImg().getH()))
        {
            if(((towerId == 11) || (towerId == 12)) && (Stats.resources[0] >= Prices.masterPrices[4]) && (Stats.resources[1] >= Prices.masterPrices[5]))
            {
                close();
                Stats.resources[0] -= Prices.masterPrices[4];
                Stats.resources[1] -= Prices.masterPrices[5];
                tileId[id] = 235;
                tiles[id] = new LightingTower("LightingTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 25, Stats.damage[12], Stats.range[12], Stats.fireDelay[12], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if(((towerId == 13) || (towerId == 14)) && (Stats.resources[2] >= Prices.masterPrices[10]) && (Stats.resources[3] >= Prices.masterPrices[11]))
            {
                close();
                Stats.resources[2] -= Prices.masterPrices[10];
                Stats.resources[2] -= Prices.masterPrices[11];
                tileId[id] = 238;
                tiles[id] = new LeafTower("LeafTower", (id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 28, Stats.damage[15], Stats.range[15], Stats.fireDelay[15], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
        }
        if(UPGRADEBUTTON2.isClick(pc, UPGRADEBUTTON2.getPosX(), UPGRADEBUTTON2.getPosY(), UPGRADEBUTTON2.getImg().getW(), UPGRADEBUTTON2.getImg().getH()))
        {
            if((towerId == 11) && (Stats.resources[0] >= Prices.masterPrices[0]))
            {
                close();
                Stats.resources[0] -= Prices.masterPrices[0];
                tileId[id] = 221;
                tiles[id] = new MasterFireTower("MasterFireTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 21, Stats.damage[8], Stats.range[8], Stats.fireDelay[8], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if((towerId == 12) && (Stats.resources[1] >= Prices.masterPrices[1]))
            {
                close();
                Stats.resources[1] -= Prices.masterPrices[1];
                tileId[id] = 222;
                tiles[id] = new MasterAirTower("MasterAirTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 22, Stats.damage[9], Stats.range[9], Stats.fireDelay[9], ((Tower)(tiles[id])).getTypePermission(), Stats.airAttackSpeedBoost[2], Stats.airRangeBoost[2]);
            }
            else if((towerId == 13) && (Stats.resources[2] >= Prices.masterPrices[2]))
            {
                close();
                Stats.resources[2] -= Prices.masterPrices[2];
                tileId[id] = 223;
                tiles[id] = new MasterWaterTower("MasterWaterTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 23, Stats.damage[10], Stats.range[10], Stats.fireDelay[10], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if((towerId == 14) && (Stats.resources[3] >= Prices.masterPrices[3]))
            {
                close();
                Stats.resources[3] -= Prices.masterPrices[3];
                tileId[id] = 224;
                tiles[id] = new MasterEarthTower("MasterEarthTower",(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 24, Stats.damage[11], Stats.range[11], Stats.fireDelay[11], ((Tower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                MasterAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
        }
        if(UPGRADEBUTTON3.isClick(pc, UPGRADEBUTTON3.getPosX(), UPGRADEBUTTON3.getPosY(), UPGRADEBUTTON3.getImg().getW(), UPGRADEBUTTON3.getImg().getH()))
        {
            if(((towerId == 11) || (towerId == 14)) && (Stats.resources[0] >= Prices.masterPrices[6]) && (Stats.resources[3] >= Prices.masterPrices[7]))
            {
                close();
                Stats.resources[0] -= Prices.masterPrices[6];
                Stats.resources[3] -= Prices.masterPrices[7];
                tileId[id] = 226;
                tiles[id] = new MagmaTower("MagmaTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 3, passedTime, 26, Stats.damage[13], Stats.range[13], Stats.fireDelay[13], ((Tower)(tiles[id])).getTypePermission());
            }
            else if(((towerId == 12) || (towerId == 13)) && (Stats.resources[1] >= Prices.masterPrices[8]) && (Stats.resources[2] >= Prices.masterPrices[9]))
            {
                close();
                Stats.resources[1] -= Prices.masterPrices[8];
                Stats.resources[2] -= Prices.masterPrices[9];
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
        MENU.setPosY(posY + y - 32);
        UPGRADEBUTTON1.setPosX(posX + x + 48);
        UPGRADEBUTTON1.setPosY(posY + y - 16);
        UPGRADEBUTTON2.setPosX(posX + x + 104);
        UPGRADEBUTTON2.setPosY(posY + y - 16);
        UPGRADEBUTTON3.setPosX(posX + x + 160);
        UPGRADEBUTTON3.setPosY(posY + y - 16);
        if(towerId == 11)
        {
            FIRE1.setPosX(posX + x + 40);
            FIRE1.setPosY(posY + y + 32);
            FIRE2.setPosX(posX + x + 96);
            FIRE2.setPosY(posY + y + 32);
            FIRE3.setPosX(posX + x + 152);
            FIRE3.setPosY(posY + y + 32);
            AIR1.setPosX(posX + x + 40);
            AIR1.setPosY(posY + y + 56);
            EARTH3.setPosX(posX + x + 152);
            EARTH3.setPosY(posY + y + 56);
        }
        else if(towerId == 12)
        {
            AIR1.setPosX(posX + x + 40);
            AIR1.setPosY(posY + y + 32);
            AIR2.setPosX(posX + x + 96);
            AIR2.setPosY(posY + y + 32);
            AIR3.setPosX(posX + x + 152);
            AIR3.setPosY(posY + y + 32);
            FIRE1.setPosX(posX + x + 40);
            FIRE1.setPosY(posY + y + 56);
            WATER3.setPosX(posX + x + 152);
            WATER3.setPosY(posY + y + 56);
        }
        else if(towerId == 13)
        {
            WATER1.setPosX(posX + x + 40);
            WATER1.setPosY(posY + y + 32);
            WATER2.setPosX(posX + x + 96);
            WATER2.setPosY(posY + y + 32);
            WATER3.setPosX(posX + x + 152);
            WATER3.setPosY(posY + y + 32);
            EARTH1.setPosX(posX + x + 40);
            EARTH1.setPosY(posY + y + 56);
            AIR3.setPosX(posX + x + 152);
            AIR3.setPosY(posY + y + 56);
        }
        else if(towerId == 14)
        {
            EARTH1.setPosX(posX + x + 40);
            EARTH1.setPosY(posY + y + 32);
            EARTH2.setPosX(posX + x + 96);
            EARTH2.setPosY(posY + y + 32);
            EARTH3.setPosX(posX + x + 152);
            EARTH3.setPosY(posY + y + 32);
            WATER1.setPosX(posX + x + 40);
            WATER1.setPosY(posY + y + 56);
            FIRE3.setPosX(posX + x + 152);
            FIRE3.setPosY(posY + y + 56);
        }
        if(typePermission[0] == true)
        {
            FIREM.setPosX(posX + x);
            FIREM.setPosY(posY + y - 32);
        }
        else
        {
            FIREM.setPosX(-1000);
            FIREM.setPosY(-1000);
        }
        if(typePermission[1] == true)
        {
            AIRM.setPosX(posX + x);
            AIRM.setPosY(posY + y);
        }
        else
        {
            AIRM.setPosX(-1000);
            AIRM.setPosY(-1000);
        }
        if(typePermission[2] == true)
        {
            WATERM.setPosX(posX + x);
            WATERM.setPosY(posY + y + 32);
        }
        else
        {
            WATERM.setPosX(-1000);
            WATERM.setPosY(-1000);
        }
        if(typePermission[3] == true)
        {
            EARTHM.setPosX(posX + x);
            EARTHM.setPosY(posY + y + 64);
        }
        else
        {
            EARTHM.setPosX(-1000);
            EARTHM.setPosY(-1000);
        }
        CLOSER.setPosX(posX + x + 224);
        CLOSER.setPosY(posY + y - 32);
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
        FIRE1.setPosX(-1000);
        FIRE1.setPosY(-1000);
        FIRE2.setPosX(-1000);
        FIRE2.setPosY(-1000);
        FIRE3.setPosX(-1000);
        FIRE3.setPosY(-1000);
        FIREM.setPosX(-1000);
        FIREM.setPosY(-1000);
        AIR1.setPosX(-1000);
        AIR1.setPosY(-1000);
        AIR2.setPosX(-1000);
        AIR2.setPosY(-1000);
        AIR3.setPosX(-1000);
        AIR3.setPosY(-1000);
        AIRM.setPosX(-1000);
        AIRM.setPosY(-1000);
        WATER1.setPosX(-1000);
        WATER1.setPosY(-1000);
        WATER2.setPosX(-1000);
        WATER2.setPosY(-1000);
        WATER3.setPosX(-1000);
        WATER3.setPosY(-1000);
        WATERM.setPosX(-1000);
        WATERM.setPosY(-1000);
        EARTH1.setPosX(-1000);
        EARTH1.setPosY(-1000);
        EARTH2.setPosX(-1000);
        EARTH2.setPosY(-1000);
        EARTH3.setPosX(-1000);
        EARTH3.setPosY(-1000);
        EARTHM.setPosX(-1000);
        EARTHM.setPosY(-1000);
    }
    public static void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, MENU.getImg(), (int)MENU.getPosX(), (int)MENU.getPosY());
        r.drawStaticImage(pc, CLOSER.getImg(), (int)CLOSER.getPosX(), (int)CLOSER.getPosY());
        r.drawStaticImage(pc, UPGRADEBUTTON1.getImg(), (int)UPGRADEBUTTON1.getPosX(), (int)UPGRADEBUTTON1.getPosY());
        r.drawStaticImage(pc, UPGRADEBUTTON2.getImg(), (int)UPGRADEBUTTON2.getPosX(), (int)UPGRADEBUTTON2.getPosY());
        r.drawStaticImage(pc, UPGRADEBUTTON3.getImg(), (int)UPGRADEBUTTON3.getPosX(), (int)UPGRADEBUTTON3.getPosY());
        r.drawStaticImage(pc, FIRE1.getImg(), (int)FIRE1.getPosX(), (int)FIRE1.getPosY());
        r.drawStaticImage(pc, AIR1.getImg(), (int)AIR1.getPosX(), (int)AIR1.getPosY());
        r.drawStaticImage(pc, WATER1.getImg(), (int)WATER1.getPosX(), (int)WATER1.getPosY());
        r.drawStaticImage(pc, EARTH1.getImg(), (int)EARTH1.getPosX(), (int)EARTH1.getPosY());
        r.drawStaticText(pc, "" + Prices.advancedPrices[0], (int)FIRE1.getPosX() + 16, (int)FIRE1.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[1], (int)AIR1.getPosX() + 16, (int)AIR1.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[2], (int)WATER1.getPosX() + 16, (int)WATER1.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[3], (int)EARTH1.getPosX() + 16, (int)EARTH1.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticImage(pc, FIRE2.getImg(), (int)FIRE2.getPosX(), (int)FIRE2.getPosY());
        r.drawStaticImage(pc, AIR2.getImg(), (int)AIR2.getPosX(), (int)AIR2.getPosY());
        r.drawStaticImage(pc, WATER2.getImg(), (int)WATER2.getPosX(), (int)WATER2.getPosY());
        r.drawStaticImage(pc, EARTH2.getImg(), (int)EARTH2.getPosX(), (int)EARTH2.getPosY());
        r.drawStaticText(pc, "" + Prices.advancedPrices[0], (int)FIRE2.getPosX() + 16, (int)FIRE2.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[1], (int)AIR2.getPosX() + 16, (int)AIR2.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[2], (int)WATER2.getPosX() + 16, (int)WATER2.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[3], (int)EARTH2.getPosX() + 16, (int)EARTH2.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticImage(pc, FIRE3.getImg(), (int)FIRE3.getPosX(), (int)FIRE3.getPosY());
        r.drawStaticImage(pc, AIR3.getImg(), (int)AIR3.getPosX(), (int)AIR3.getPosY());
        r.drawStaticImage(pc, WATER3.getImg(), (int)WATER3.getPosX(), (int)WATER3.getPosY());
        r.drawStaticImage(pc, EARTH3.getImg(), (int)EARTH3.getPosX(), (int)EARTH3.getPosY());
        r.drawStaticText(pc, "" + Prices.advancedPrices[0], (int)FIRE3.getPosX() + 16, (int)FIRE3.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[1], (int)AIR3.getPosX() + 16, (int)AIR3.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[2], (int)WATER3.getPosX() + 16, (int)WATER3.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticText(pc, "" + Prices.advancedPrices[3], (int)EARTH3.getPosX() + 16, (int)EARTH3.getPosY() + 16, 0xFF000000, 15);
        r.drawStaticImage(pc, FIREM.getImg(), (int)FIREM.getPosX(), (int)FIREM.getPosY());
        r.drawStaticImage(pc, AIRM.getImg(), (int)AIRM.getPosX(), (int)AIRM.getPosY());
        r.drawStaticImage(pc, WATERM.getImg(), (int)WATERM.getPosX(), (int)WATERM.getPosY());
        r.drawStaticImage(pc, EARTHM.getImg(), (int)EARTHM.getPosX(), (int)EARTHM.getPosY());
    }
}

