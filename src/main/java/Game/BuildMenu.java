package Game;

import Map.Tile;
import Map.TowerPlace;
import Map.Towers.AirTower;
import Map.Towers.EarthTower;
import Map.Towers.FireTower;
import Map.Towers.WaterTower;
import engine.*;

public class BuildMenu extends Field
{
    private static int id;
    public static  BuildMenu menu = new  BuildMenu("/res/upgradeMenu.png", -1000, -1000, 128, 160, 0);
    public static Button closer = new Button("/res/upgradeMenuCloser.png", -1000, -1000, 16, 16, 0);
    private static final Button FIRE = new Button("/res/towers/summoningTileFire.png", -1000, -1000, 64, 64, 0);
    private static final Button AIR = new Button("/res/towers/summoningTileAir.png", -1000, -1000,64, 64, 0);
    private static final Button WATER = new Button("/res/towers/summoningTileWater.png", -1000, -1000,64, 64, 0);
    private static final Button EARTH = new Button("/res/towers/summoningTileEarth.png", -1000, -1000,64, 64, 0);
    private static final Field FIREm = new Field("/res/towers/summoningTileFire.png", -1000, -1000, 32, 32, 0);
    private static final Field AIRm = new Field("/res/towers/summoningTileAir.png", -1000, -1000, 32, 32, 0);
    private static final Field WATERm = new Field("/res/towers/summoningTileWater.png", -1000, -1000, 32, 32, 0);
    private static final Field EARTHm = new Field("/res/towers/summoningTileEarth.png", -1000, -1000, 32, 32, 0);
    public  BuildMenu(String path, double posX, double posY, int width, int height, int frame) {
        super(path, posX, posY, width, height, frame);
        id = -1;
    }
    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        if(closer.isClick(pc, closer.getPosX(), closer.getPosY(), closer.getImg().getW(), closer.getImg().getH()))
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
        }
        if((AIR.isClick(pc, AIR.getPosX(), AIR.getPosY(), AIR.getImg().getW(), AIR.getImg().getH())) && (Stats.air >= Prices.basicPrices[1]))
        {
            close();
            Stats.air -= Prices.basicPrices[1];
            tileId[id] = 22;
            tiles[id] = new AirTower("AirTower", tiles,(id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 2, 0, Stats.fireRange, Stats.fireFireDelay, ((TowerPlace)(tiles[id])).getTypePermission(), Stats.getAirAttackSpeedBoost(), Stats.getAirRangeBoost());
        }
        if((WATER.isClick(pc, WATER.getPosX(), WATER.getPosY(), WATER.getImg().getW(), WATER.getImg().getH())) && (Stats.water >= Prices.basicPrices[2]))
        {
            close();
            Stats.water -= Prices.basicPrices[2];
            tileId[id] = 23;
            tiles[id] = new WaterTower("WaterTower", (id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 3, Stats.waterDmg, Stats.waterRange, Stats.waterFireDelay, ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
        if((EARTH.isClick(pc, EARTH.getPosX(), EARTH.getPosY(), EARTH.getImg().getW(), EARTH.getImg().getH())) && (Stats.earth >= Prices.basicPrices[3]))
        {
            close();
            Stats.earth -= Prices.basicPrices[3];
            tileId[id] = 24;
            tiles[id] = new EarthTower("EarthTower", (id % 16) * 64, (id / 16) * 64, id, 1, passedTime, 4, Stats.earthDmg, Stats.earthRange, Stats.earthFireDelay, ((TowerPlace)(tiles[id])).getTypePermission());
            AirTower.boostCheck(tiles, id, (id % 16) * 64, (id / 16) * 64);
        }
    }
    public static void render(ProgramContainer pc, Renderer r, Prices prices)
    {
        r.drawStaticImage(pc, menu.getImg(), (int)menu.getPosX(), (int)menu.getPosY());
        r.drawStaticImage(pc, closer.getImg(), (int)closer.getPosX(), (int)closer.getPosY());
        r.drawStaticImage(pc, FIRE.getImg(), (int)FIRE.getPosX(), (int)FIRE.getPosY());
        r.drawStaticImage(pc, AIR.getImg(), (int)AIR.getPosX(), (int)AIR.getPosY());
        r.drawStaticImage(pc, WATER.getImg(), (int)WATER.getPosX(), (int)WATER.getPosY());
        r.drawStaticImage(pc, EARTH.getImg(), (int)EARTH.getPosX(), (int)EARTH.getPosY());
        r.drawStaticImage(pc, FIREm.getImg(), (int)FIREm.getPosX(), (int)FIREm.getPosY());
        r.drawStaticImage(pc, AIRm.getImg(), (int)AIRm.getPosX(), (int)AIRm.getPosY());
        r.drawStaticImage(pc, WATERm.getImg(), (int)WATERm.getPosX(), (int)WATERm.getPosY());
        r.drawStaticImage(pc, EARTHm.getImg(), (int)EARTHm.getPosX(), (int)EARTHm.getPosY());
        r.drawStaticText(pc, "" + prices.getBasicPrices()[0], (int)FIRE.getPosX() + 12, (int)FIRE.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[1], (int)AIR.getPosX() + 12, (int)AIR.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[2], (int)WATER.getPosX() + 12, (int)WATER.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[3], (int)EARTH.getPosX() + 12, (int)EARTH.getPosY() + 32, 0xFF000000, 3);
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
            menu.setPosX(posX + x);
            menu.setPosY(posY + y - 32);
            if(typePermission[0] == true)
            {
                FIRE.setPosX(posX + x);
                FIRE.setPosY(posY + y);
                FIREm.setPosX(posX + x);
                FIREm.setPosY(posY + y - 32);
            }
            else
            {
                FIRE.setPosX(-1000);
                FIRE.setPosY(-1000);
                FIREm.setPosX(-1000);
                FIREm.setPosY(-1000);
            }
            if(typePermission[1] == true)
            {
                AIR.setPosX(posX + x + 64);
                AIR.setPosY(posY + y);
                AIRm.setPosX(posX + x + 32);
                AIRm.setPosY(posY + y - 32);
            }
            else
            {
                AIR.setPosX(-1000);
                AIR.setPosY(-1000);
                AIRm.setPosX(-1000);
                AIRm.setPosY(-1000);
            }
            if(typePermission[2] == true)
            {
                WATER.setPosX(posX + x);
                WATER.setPosY(posY + y + 64);
                WATERm.setPosX(posX + x + 64);
                WATERm.setPosY(posY + y - 32);
            }
            else
            {
                WATER.setPosX(-1000);
                WATER.setPosY(-1000);
                WATERm.setPosX(-1000);
                WATERm.setPosY(-1000);
            }
            if(typePermission[3] == true)
            {
                EARTH.setPosX(posX + x + 64);
                EARTH.setPosY(posY + y + 64);
                EARTHm.setPosX(posX + x + 96);
                EARTHm.setPosY(posY + y - 32);
            }
            else
            {
                EARTH.setPosX(-1000);
                EARTH.setPosY(-1000);
                EARTHm.setPosX(-1000);
                EARTHm.setPosY(-1000);
            }
            closer.setPosX(posX + x + 128);
            closer.setPosY(posY + y - 16);
    }
    public static void close()
    {
        Input.justClicked = false;
        menu.setPosX(-1000);
        menu.setPosY(-1000);
        closer.setPosX(-1000);
        closer.setPosY(-1000);
        FIRE.setPosX(-1000);
        FIRE.setPosY(-1000);
        FIREm.setPosX(-1000);
        FIREm.setPosY(-1000);
        AIR.setPosX(-1000);
        AIR.setPosY(-1000);
        AIRm.setPosX(-1000);
        AIRm.setPosY(-1000);
        WATER.setPosX(-1000);
        WATER.setPosY(-1000);
        WATERm.setPosX(-1000);
        WATERm.setPosY(-1000);
        EARTH.setPosX(-1000);
        EARTH.setPosY(-1000);
        EARTHm.setPosX(-1000);
        EARTHm.setPosY(-1000);
    }
}

