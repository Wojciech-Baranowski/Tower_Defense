package Game;

import Entities.EnemyImageSheet;
import engine.Animation;
import engine.Font;
import engine.Image;

public class Assets
{

    public static final Image MENUGUI = new Image("/gui/menuGui.png", 352, 288, 0);
    public static final Image MENUGUIBUTTON = new Image("/gui/menuGuiButton.png", 288, 48, 0);
    public static final Image MENUGUIBUTTONCKICKED = new Image("/gui/menuGuiButtonClicked.png", 288, 48, 0);

    public static final Image BLANK = new Image("/blank.png", 1, 1, 0);
    public static final Image BLANK64 = new Image("/blank.png", 64, 64, 0);
    public static final Image DEFAULTFIELD = new Image("/defaultField.png", 1, 1, 0);
    public static final Image BACKGROUND = new Image("/background.png", 1024, 576, 0);

    public static final Image HEALTHBARFULL = new Image("/entities/healthBarFull.png", 16, 2, 0);

    public static final Image CLOSER = new Image("/gui/menuCloser.png", 24, 24, 0);
    public static final Image BUILDMENU = new Image("/gui/buildMenu.png", 128, 128, 0);
    public static final Image BASICUPGRADEMENU = new Image("/gui/basicUpgradeMenu.png", 128, 128, 0);
    public static final Image ADVANCEDUPGRADEMENU = new Image("/gui/advancedUpgradeMenu.png", 128, 128, 0);

    public static final Image UPGRADEBUTTON48 = new Image("/gui/upgradeMenuArrow.png", 48, 48, 0);
    public static final Image UPGRADEBUTTON64 = new Image("/gui/upgradeMenuArrow.png", 64, 64, 0);

    public static final Image HP = new Image("/emblems/hp.png", 24, 24, 0);

    public static final Image FIRE24 = new Image("/emblems/fire.png", 24, 24, 0);
    public static final Image AIR24 = new Image("/emblems/air.png", 24, 24, 0);
    public static final Image WATER24 = new Image("/emblems/water.png", 24, 24, 0);
    public static final Image EARTH24 = new Image("/emblems/earth.png",  24, 24, 0);
    public static final Image ENERGY24 = new Image("/emblems/energy.png", 24, 24, 0);

    public static final Image FIRE32 = new Image("/emblems/fire.png", 32, 32, 0);
    public static final Image AIR32 = new Image("/emblems/air.png", 32, 32, 0);
    public static final Image WATER32 = new Image("/emblems/water.png", 32, 32, 0);
    public static final Image EARTH32 = new Image("/emblems/earth.png",  32, 32, 0);
    public static final Image ENERGY32 = new Image("/emblems/energy.png", 32, 32, 0);

    public static final Image FIRE40 = new Image("/emblems/fire.png",  40, 40, 0);
    public static final Image AIR40 = new Image("/emblems/air.png", 40, 40, 0);
    public static final Image WATER40 = new Image("/emblems/water.png", 40, 40, 0);
    public static final Image EARTH40 = new Image("/emblems/earth.png", 40, 40, 0);
    public static final Image ENERGY40 = new Image("/emblems/energy.png", 40, 40, 0);

    public static final Image FIRE48 = new Image("/emblems/fire.png",  48, 48, 0);
    public static final Image AIR48 = new Image("/emblems/air.png", 48, 48, 0);
    public static final Image WATER48 = new Image("/emblems/water.png", 48, 48, 0);
    public static final Image EARTH48 = new Image("/emblems/earth.png", 48, 48, 0);
    public static final Image ENERGY48 = new Image("/emblems/energy.png", 48, 48, 0);

    public static final Image FIRE64 = new Image("/emblems/fire.png",  64, 64, 0);
    public static final Image AIR64 = new Image("/emblems/air.png", 64, 64, 0);
    public static final Image WATER64 = new Image("/emblems/water.png", 64, 64, 0);
    public static final Image EARTH64 = new Image("/emblems/earth.png", 64, 64, 0);
    public static final Image ENERGY64 = new Image("/emblems/energy.png", 64, 64, 0);

    public static final Image GUI = new Image("/gui/gui.png", 1024, 576, 0);
    public static final Image GUIBUTTON = new Image("/gui/guiButton.png", 48, 48, 0);
    public static final Image GUIBUTTONCLICKED = new Image("/gui/guiButtonClicked.png", 48, 48, 0);

    public static final Image SUMMONINGTILE = new Image("/towers/summoningTile.png", 64, 64, 0);
    public static final Image BOOSTMARK = new Image("/towers/boostMark.png",64, 64, 0);
    public static final Image MAGMA = new Image("/towers/magma.png", 64, 64, 0);

    public static final Image AIRTOWER = new Image("/towers/airTower.png",64, 64, 0);
    public static final Image EARTHTOWER = new Image("/towers/earthTower.png",64, 64, 0);
    public static final Image FIRETOWER = new Image("/towers/fireTower.png",64, 64, 0);
    public static final Image WATERTOWER = new Image("/towers/waterTower.png",64, 64, 0);

    public static final Image ADVANCEDAIRTOWER = new Image("/towers/advancedAirTower.png",64, 64, 0);
    public static final Image ADVANCEDEARTHTOWER = new Image("/towers/advancedEarthTower.png",64, 64, 0);
    public static final Image ADVANCEDFIRETOWER = new Image("/towers/advancedFireTower.png",64, 64, 0);
    public static final Image ADVANCEDWATERTOWER = new Image("/towers/advancedWaterTower.png",64, 64, 0);

    public static final Image MASTERAIRTOWER = new Image("/towers/masterAirTower.png",64, 64, 0);
    public static final Image MASTEREARTHTOWER = new Image("/towers/masterEarthTower.png",64, 64, 0);
    public static final Image MASTERFIRETOWER = new Image("/towers/masterFireTower.png",64, 64, 0);
    public static final Image MASTERWATERTOWER = new Image("/towers/masterWaterTower.png",64, 64, 0);

    public static final Image LIGHTINGTOWER = new Image("/towers/lightingTower.png",64, 64, 0);
    public static final Image MAGMATOWER = new Image("/towers/magmaTower.png",64, 64, 0);
    public static final Image ICETOWER = new Image("/towers/iceTower.png",64, 64, 0);
    public static final Image LEAFTOWER = new Image("/towers/leafTower.png",64, 64, 0);

    public static final Image EARTHBULLET = new Image("/entities/bullets/earthBullet.png", 8, 8, 0);
    public static final Image FIREBULLET = new Image("/entities/bullets/fireBullet.png", 8, 2, 0);
    public static final Image WATERBULLET = new Image("/entities/bullets/waterBullet.png", 4, 8, 0);
    public static final Image ICEBULLET = new Image("/entities/bullets/iceBullet.png", 5, 9, 0);
    public static final Image LEAFBULLET = new Image("/entities/bullets/leafBullet.png", 8, 6, 0);

    public static final Font FONT = new Font("/fonts/sansBold.png", 2310, 40);

    public static final Animation SUMMONINGTILEANIMA = new Animation("/towers/summoningTileAnimation.png", 6, 64, 64, 4);

    public static final Animation AIRANIMA24 = new Animation("/emblems/airAnimation.png", 6, 24, 24, 6);
    public static final Animation EARTHANIMA24 = new Animation("/emblems/earthAnimation.png", 6, 24, 24, 6);
    public static final Animation FIREANIMA24 = new Animation("/emblems/fireAnimation.png", 6, 24, 24, 6);
    public static final Animation WATERANIMA24 = new Animation("/emblems/waterAnimation.png", 6, 24, 24, 6);
    public static final Animation ENERGYANIMA24 = new Animation("/emblems/energyAnimation.png", 6, 24, 24, 6);

    public static final Animation AIRANIMA32 = new Animation("/emblems/airAnimation.png", 6, 32, 32, 6);
    public static final Animation EARTHANIMA32 = new Animation("/emblems/earthAnimation.png", 6, 32, 32, 6);
    public static final Animation FIREANIMA32 = new Animation("/emblems/fireAnimation.png", 6, 32, 32, 6);
    public static final Animation WATERANIMA32 = new Animation("/emblems/waterAnimation.png", 6, 32, 32, 6);
    public static final Animation ENERGYANIMA32 = new Animation("/emblems/energyAnimation.png", 6, 32, 32, 6);

    public static final Animation AIRANIMA40 = new Animation("/emblems/airAnimation.png", 6, 40, 40, 6);
    public static final Animation EARTHANIMA40 = new Animation("/emblems/earthAnimation.png", 6, 40, 40, 6);
    public static final Animation FIREANIMA40 = new Animation("/emblems/fireAnimation.png", 6, 40, 40, 6);
    public static final Animation WATERANIMA40 = new Animation("/emblems/waterAnimation.png", 6, 40, 40, 6);
    public static final Animation ENERGYANIMA40 = new Animation("/emblems/energyAnimation.png", 6, 40, 40, 6);

    public static final Animation AIRANIMA48 = new Animation("/emblems/airAnimation.png", 6, 48, 48, 6);
    public static final Animation EARTHANIMA48 = new Animation("/emblems/earthAnimation.png", 6, 48, 48, 6);
    public static final Animation FIREANIMA48 = new Animation("/emblems/fireAnimation.png", 6, 48, 48, 6);
    public static final Animation WATERANIMA48 = new Animation("/emblems/waterAnimation.png", 6, 48, 48, 6);
    public static final Animation ENERGYANIMA48 = new Animation("/emblems/energyAnimation.png", 6, 48, 48, 6);


    public static final Animation AIRANIMA64 = new Animation("/emblems/airAnimation.png", 6, 64, 64, 6);
    public static final Animation EARTHANIMA64 = new Animation("/emblems/earthAnimation.png", 6, 64, 64, 6);
    public static final Animation FIREANIMA64 = new Animation("/emblems/fireAnimation.png", 6, 64, 64, 6);
    public static final Animation WATERANIMA64 = new Animation("/emblems/waterAnimation.png", 6, 64, 64, 6);
    public static final Animation ENERGYANIMA64 = new Animation("/emblems/energyAnimation.png", 6, 64, 64, 6);

    public static final EnemyImageSheet PEASANT = new EnemyImageSheet("/entities/enemies/peasant.png", 24);
    public static final EnemyImageSheet WOLF = new EnemyImageSheet("/entities/enemies/wolf.png", 24);
    public static final EnemyImageSheet BANDIT = new EnemyImageSheet("/entities/enemies/bandit.png", 24);
    public static final EnemyImageSheet BERSERKER = new EnemyImageSheet("/entities/enemies/berserker.png", 36);
    public static final EnemyImageSheet KNIGHT = new EnemyImageSheet("/entities/enemies/knight.png", 24);
}
