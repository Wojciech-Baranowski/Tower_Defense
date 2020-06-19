package Game.gui;
import Game.Assets;
import Game.Prices;
import Game.Stats;
import Map.Tile;
import Map.Towers.*;
import engine.*;

public class BasicUpgradeMenu
{
    private static int id = -1;
    private static int towerId = -1;
    public static final Button MENU = new Button(Assets.UPGRADEMENU, -1000, -1000);
    public static final Button CLOSER = new Button(Assets.CLOSER, -1000, -1000);
    public static final Button UPGRADEBUTTON = new Button(Assets.UPGRADEBUTTON, -1000, -1000);
    private static final Button FIRE = new Button(Assets.FIRE48, -1000, -1000);
    private static final Button AIR = new Button(Assets.AIR48, -1000, -1000);
    private static final Button WATER = new Button(Assets.WATER48, -1000, -1000);
    private static final Button EARTH = new Button(Assets.EARTH48, -1000, -1000);
    private static final Field FIREM = new Field(Assets.FIRE32, -1000, -1000);
    private static final Field AIRM = new Field(Assets.AIR32, -1000, -1000);
    private static final Field WATERM = new Field(Assets.WATER32, -1000, -1000);
    private static final Field EARTHM = new Field(Assets.EARTH32, -1000, -1000);
    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        AIR.setImg(Assets.AIRANIMA48.updateLoop(AIR.getImg(), World.tickCount));
        EARTH.setImg(Assets.EARTHANIMA48.updateLoop(EARTH.getImg(), World.tickCount));
        FIRE.setImg(Assets.FIREANIMA48.updateLoop(FIRE.getImg(), World.tickCount));
        WATER.setImg(Assets.WATERANIMA48.updateLoop(WATER.getImg(), World.tickCount));
        AIRM.setImg(Assets.AIRANIMA32.updateLoop(AIRM.getImg(), World.tickCount));
        EARTHM.setImg(Assets.EARTHANIMA32.updateLoop(EARTHM.getImg(), World.tickCount));
        FIREM.setImg(Assets.FIREANIMA32.updateLoop(FIREM.getImg(), World.tickCount));
        WATERM.setImg(Assets.WATERANIMA32.updateLoop(WATERM.getImg(), World.tickCount));
        if(CLOSER.isClick(pc, CLOSER.getPosX(), CLOSER.getPosY(), CLOSER.getImg().getW(), CLOSER.getImg().getH()))
        {
            BasicUpgradeMenu.close();
        }
        if(UPGRADEBUTTON.isClick(pc, UPGRADEBUTTON.getPosX(), UPGRADEBUTTON.getPosY(), UPGRADEBUTTON.getImg().getW(), UPGRADEBUTTON.getImg().getH()))
        {
            if((towerId == 1) && (Stats.fire >= Prices.advancedPrices[0]))
            {
                close();
                Stats.fire -= Prices.advancedPrices[0];
                tileId[id] = 211;
                tiles[id] = new AdvancedFireTower("AdvancedFireTower",(id % 16) * 64, (id / 16) * 64, id, 2, passedTime, 11, Stats.advancedFireDmg, Stats.advancedFireRange, Stats.advancedFireFireDelay, ((FireTower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if((towerId == 2) && (Stats.air >= Prices.advancedPrices[1]))
            {
                close();
                Stats.air -= Prices.advancedPrices[1];
                tileId[id] = 212;
                tiles[id] = new AdvancedAirTower("AdvancedAirTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 2, passedTime, 12, 0, Stats.advancedAirRange, 0, ((AirTower)(tiles[id])).getTypePermission(), Stats.getAdvancedAirAttackSpeedBoost(), Stats.getAdvancedAirRangeBoost());
            }
            else if((towerId == 3) && (Stats.earth >= Prices.advancedPrices[2]))
            {
                close();
                Stats.water -= Prices.basicPrices[2];
                tileId[id] = 213;
                tiles[id] = new AdvancedWaterTower("AdvancedWaterTower", (id % 16) * 64, (id / 16) * 64, id, 2, passedTime, 13, Stats.advancedWaterDmg, Stats.advancedWaterRange, Stats.advancedWaterFireDelay, ((WaterTower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            }
            else if((towerId == 4) && (Stats.earth >= Prices.advancedPrices[3]))
            {
                close();
                Stats.earth -= Prices.basicPrices[3];
                tileId[id] = 214;
                tiles[id] = new AdvancedEarthTower("AdvancedEarthTower", (id % 16) * 64, (id / 16) * 64, id, 2, passedTime, 14, Stats.advancedEarthDmg, Stats.advancedEarthRange, Stats.advancedEarthFireDelay, ((EarthTower)(tiles[id])).getTypePermission());
                AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
                AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
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
        MENU.setPosY(posY + y - 32);
        UPGRADEBUTTON.setPosX(posX + x + 48);
        UPGRADEBUTTON.setPosY(posY + y - 16);
        if(towerId == 1)
        {
            FIRE.setPosX(posX + x + 32);
            FIRE.setPosY(posY + y + 48);
        }
        else if(towerId == 2)
        {
            AIR.setPosX(posX + x + 32);
            AIR.setPosY(posY + y + 48);
        }
        else if(towerId == 3)
        {
            WATER.setPosX(posX + x + 32);
            WATER.setPosY(posY + y + 48);
        }
        else if(towerId == 4)
        {
            EARTH.setPosX(posX + x + 32);
            EARTH.setPosY(posY + y + 48);
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
        CLOSER.setPosX(posX + x + 128);
        CLOSER.setPosY(posY + y - 32);
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
    public static void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, MENU.getImg(), (int)MENU.getPosX(), (int)MENU.getPosY());
        r.drawStaticImage(pc, CLOSER.getImg(), (int)CLOSER.getPosX(), (int)CLOSER.getPosY());
        r.drawStaticImage(pc, UPGRADEBUTTON.getImg(), (int)UPGRADEBUTTON.getPosX(), (int)UPGRADEBUTTON.getPosY());
        r.drawStaticImage(pc, FIRE.getImg(), (int)FIRE.getPosX(), (int)FIRE.getPosY());
        r.drawStaticImage(pc, AIR.getImg(), (int)AIR.getPosX(), (int)AIR.getPosY());
        r.drawStaticImage(pc, WATER.getImg(), (int)WATER.getPosX(), (int)WATER.getPosY());
        r.drawStaticImage(pc, EARTH.getImg(), (int)EARTH.getPosX(), (int)EARTH.getPosY());
        r.drawStaticText(pc, "" + Prices.advancedPrices[0], (int)FIRE.getPosX() + 28, (int)FIRE.getPosY() + 16, 0xFF000000, 3);
        r.drawStaticText(pc, "" + Prices.advancedPrices[1], (int)AIR.getPosX() + 28, (int)AIR.getPosY() + 16, 0xFF000000, 3);
        r.drawStaticText(pc, "" + Prices.advancedPrices[2], (int)WATER.getPosX() + 28, (int)WATER.getPosY() + 16, 0xFF000000, 3);
        r.drawStaticText(pc, "" + Prices.advancedPrices[3], (int)EARTH.getPosX() + 28, (int)EARTH.getPosY() + 16, 0xFF000000, 3);
        r.drawStaticImage(pc, FIREM.getImg(), (int)FIREM.getPosX(), (int)FIREM.getPosY());
        r.drawStaticImage(pc, AIRM.getImg(), (int)AIRM.getPosX(), (int)AIRM.getPosY());
        r.drawStaticImage(pc, WATERM.getImg(), (int)WATERM.getPosX(), (int)WATERM.getPosY());
        r.drawStaticImage(pc, EARTHM.getImg(), (int)EARTHM.getPosX(), (int)EARTHM.getPosY());
    }
}

