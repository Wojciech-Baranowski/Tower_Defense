package Game;

import engine.Button;
import engine.Field;
import engine.Font;
import engine.Image;

public class Assets
{
    public static final Image BLANK = new Image("/blank.png", 1, 1, 0);
    public static final Image DEFAULTFIELD = new Image("/defaultField.png", 1, 1, 0);
    public static final Image BACKGROUND = new Image("/background.png", 1024, 576, 1);

    public static final Image CRYSTALBALL = new Image("/entities/crystalBall.png", 16, 16, 0);
    public static final Image CRYSTALSHARD = new Image("/entities/crystalShard.png", 16, 16, 0);
    public static final Image DOBBO = new Image("/entities/dobbo.png", 32, 32, 0);

    public static final Image HEALTHBARFULL = new Image("/entities/healthBarFull.png", 16, 2, 0);

    public static final Image MENU = new Image("/gui/buildMenu.png", 128, 160, 0);
    public static final Image UPGRADEMENU = new Image("/gui/basicUpgradeMenu.png", 128, 128, 0);
    public static final Image CLOSER = new Image("/gui/menuCloser.png", 16, 16, 0);
    public static final Image UPGRADEBUTTON = new Image("/gui/upgradeMenuArrow.png", 64, 64, 0);
    public static final Image FIRE = new Image("/towers/summoningTileFire.png",  64, 64, 0);
    public static final Image AIR = new Image("/towers/summoningTileAir.png", 64, 64, 0);
    public static final Image WATER = new Image("/towers/summoningTileWater.png", 64, 64, 0);
    public static final Image EARTH = new Image("/towers/summoningTileEarth.png", 64, 64, 0);
    public static final Image FIREM = new Image("/towers/summoningTileFire.png", 32, 32, 0);
    public static final Image AIRM = new Image("/towers/summoningTileAir.png", 32, 32, 0);
    public static final Image WATERM = new Image("/towers/summoningTileWater.png", 32, 32, 0);
    public static final Image EARTHM = new Image("/towers/summoningTileEarth.png",  32, 32, 0);

    public static final Image GUI = new Image("/gui/gui.png", 1024, 576, 0xFF641D54);
    public static final Image GUIBUTTON = new Image("/gui/guiButton.png", 96, 48, 0xFF641D54);
    public static final Image GUIBUTTONCLICKED = new Image("/gui/guiButtonClicked.png", 96, 48, 0xFF641D54);

    public static final Image SUMMONINGTILE = new Image("/towers/summoningTile.png", 64, 64, 0);
    public static final Image BOOSTMARK = new Image("/towers/boostMark.png",64, 64, 0);

    public static final Image AIRTOWER = new Image("/towers/airTower.png",64, 64, 0);
    public static final Image EARTHTOWER = new Image("/towers/earthTower.png",64, 64, 0);
    public static final Image FIRETOWER = new Image("/towers/fireTower.png",64, 64, 0);
    public static final Image WATERTOWER = new Image("/towers/waterTower.png",64, 64, 0);

    public static final Image ADVANCEDAIRTOWER = new Image("/towers/advancedAirTower.png",64, 64, 0);
    public static final Image ADVANCEDEARTHTOWER = new Image("/towers/advancedEarthTower.png",64, 64, 0);
    public static final Image ADVANCEDFIRETOWER = new Image("/towers/advancedFireTower.png",64, 64, 0);
    public static final Image ADVANCEDWATERTOWER = new Image("/towers/advancedWaterTower.png",64, 64, 0);

    public static final Image EARTHBOMB = new Image("/entities/bullets/earthBomb.png", 8, 8, 0);
    public static final Image FIREARROW = new Image("/entities/bullets/fireArrow.png", 8, 2, 0);
    public static final Image WATERBULLET = new Image("/entities/bullets/waterBullet.png", 4, 8, 0);

    public static final Font F25 = new Font("/fonts/font.png", 1184, 23);
    public static final Font F20 = new Font("/fonts/font2.png", 954, 18);
    public static final Font F15 = new Font("/fonts/font3.png", 688, 13);
    public static final Font FB25 = new Font("/fonts/fontB.png", 1500, 25);
    public static final Font FB20 = new Font("/fonts/font2B.png", 1000, 17);
    public static final Font FB15 = new Font("/fonts/font3B.png", 1000, 15);
}
