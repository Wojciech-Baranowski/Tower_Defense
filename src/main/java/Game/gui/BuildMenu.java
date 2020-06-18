package Game.gui;

import Game.Assets;
import Game.Prices;
import Game.Stats;
import Map.Tile;
import Map.TowerPlace;
import Map.Towers.*;
import engine.*;

public class BuildMenu implements Clickable
{
    private static int id = -1;
    public static final Button MENU = new Button(Assets.MENU, -1000, -1000);
    public static final Button CLOSER = new Button(Assets.CLOSER, -1000, -1000);
    private static final Button FIRE = new Button(Assets.FIRE, -1000, -1000);
    private static final Button AIR = new Button(Assets.AIR, -1000, -1000);
    private static final Button WATER = new Button(Assets.WATER, -1000, -1000);
    private static final Button EARTH = new Button(Assets.EARTH, -1000, -1000);
    private static final Field FIREM = new Field(Assets.FIREM, -1000, -1000);
    private static final Field AIRM = new Field(Assets.AIRM, -1000, -1000);
    private static final Field WATERM = new Field(Assets.WATERM, -1000, -1000);
    private static final Field EARTHM = new Field(Assets.EARTHM, -1000, -1000);
    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        if(CLOSER.isClick(pc, CLOSER.getPosX(), CLOSER.getPosY(), CLOSER.getImg().getW(), CLOSER.getImg().getH()))
        {
            BuildMenu.close();
        }
        if((FIRE.isClick(pc, FIRE.getPosX(), FIRE.getPosY(), FIRE.getImg().getW(), FIRE.getImg().getH())) && (Stats.fire >= Prices.basicPrices[0]))
        {
            close();
            Stats.fire -= Prices.basicPrices[0];
            tileId[id] = 21;
            tiles[id] = new FireTower("FireTower",(id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 1, Stats.fireDmg, Stats.fireRange, Stats.fireFireDelay, ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
        if((AIR.isClick(pc, AIR.getPosX(), AIR.getPosY(), AIR.getImg().getW(), AIR.getImg().getH())) && (Stats.air >= Prices.basicPrices[1]))
        {
            close();
            Stats.air -= Prices.basicPrices[1];
            tileId[id] = 22;
            tiles[id] = new AirTower("AirTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 2, 0, Stats.fireRange, 0, ((TowerPlace)(tiles[id])).getTypePermission(), Stats.getAirAttackSpeedBoost(), Stats.getAirRangeBoost());
        }
        if((WATER.isClick(pc, WATER.getPosX(), WATER.getPosY(), WATER.getImg().getW(), WATER.getImg().getH())) && (Stats.water >= Prices.basicPrices[2]))
        {
            close();
            Stats.water -= Prices.basicPrices[2];
            tileId[id] = 23;
            tiles[id] = new WaterTower("WaterTower", (id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 3, Stats.waterDmg, Stats.waterRange, Stats.waterFireDelay, ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
        if((EARTH.isClick(pc, EARTH.getPosX(), EARTH.getPosY(), EARTH.getImg().getW(), EARTH.getImg().getH())) && (Stats.earth >= Prices.basicPrices[3]))
        {
            close();
            Stats.earth -= Prices.basicPrices[3];
            tileId[id] = 24;
            tiles[id] = new EarthTower("EarthTower", (id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 4, Stats.earthDmg, Stats.earthRange, Stats.earthFireDelay, ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
            AdvancedAirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
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
        r.drawStaticText(pc, "" + Prices.basicPrices[0], (int)FIRE.getPosX() + 12, (int)FIRE.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + Prices.basicPrices[1], (int)AIR.getPosX() + 12, (int)AIR.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + Prices.basicPrices[2], (int)WATER.getPosX() + 12, (int)WATER.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + Prices.basicPrices[3], (int)EARTH.getPosX() + 12, (int)EARTH.getPosY() + 32, 0xFF000000, 3);
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
            y = -32;
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
            MENU.setPosY(posY + y - 32);
            if(typePermission[0] == true)
            {
                FIRE.setPosX(posX + x);
                FIRE.setPosY(posY + y);
                FIREM.setPosX(posX + x);
                FIREM.setPosY(posY + y - 32);
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
                AIR.setPosX(posX + x + 64);
                AIR.setPosY(posY + y);
                AIRM.setPosX(posX + x + 32);
                AIRM.setPosY(posY + y - 32);
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
                WATER.setPosX(posX + x);
                WATER.setPosY(posY + y + 64);
                WATERM.setPosX(posX + x + 64);
                WATERM.setPosY(posY + y - 32);
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
                EARTH.setPosX(posX + x + 64);
                EARTH.setPosY(posY + y + 64);
                EARTHM.setPosX(posX + x + 96);
                EARTHM.setPosY(posY + y - 32);
            }
            else
            {
                EARTH.setPosX(-1000);
                EARTH.setPosY(-1000);
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

