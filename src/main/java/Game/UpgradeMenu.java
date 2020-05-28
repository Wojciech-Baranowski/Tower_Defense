package Game;

import engine.*;

public class UpgradeMenu extends Field
{
    public static UpgradeMenu menu = new UpgradeMenu("/res/upgradeMenu.png", -1000, -1000, 128, 128, 0);
    public static Button closer = new Button("/res/upgradeMenuCloser.png", -1000, -1000, 16, 16, 0);
    private static final Button FIRE = new Button("/res/towers/summoningTileFire.png", -1000, -1000, 64, 64, 0);
    private static final Button AIR = new Button("/res/towers/summoningTileAir.png", -1000, -1000,64, 64, 0);
    private static final Button WATER = new Button("/res/towers/summoningTileWater.png", -1000, -1000,64, 64, 0);
    private static final Button EARTH = new Button("/res/towers/summoningTileEarth.png", -1000, -1000,64, 64, 0);
    public UpgradeMenu(String path, int posX, int posY, int width, int height, int frame) {
        super(path, posX, posY, width, height, frame);
    }
    public static void update(ProgramContainer pc)
    {
        closer.holdClick(pc);

        if(closer.isJustClicked())
        {
            UpgradeMenu.close();
        }
    }
    public static void render(ProgramContainer pc, Renderer r)
    {
        r.drawStaticImage(pc, menu.getImg(), menu.getPosX(), menu.getPosY());
        r.drawStaticImage(pc, closer.getImg(), closer.getPosX(), closer.getPosY());
        r.drawStaticImage(pc, FIRE.getImg(), FIRE.getPosX(), FIRE.getPosY());
        r.drawStaticImage(pc, AIR.getImg(), AIR.getPosX(), AIR.getPosY());
        r.drawStaticImage(pc, WATER.getImg(), WATER.getPosX(), WATER.getPosY());
        r.drawStaticImage(pc, EARTH.getImg(), EARTH.getPosX(), EARTH.getPosY());
    }
    public static void open(int posX, int posY, boolean[] typePermission)
    {
        //TODO przerobic na zmienne, bo za duzo jebania
        if(posY >= 192)
        {
            menu.setPosX(posX - 32);
            menu.setPosY(posY - 140);
            if(typePermission[0] == true)
            {
                FIRE.setPosX(posX - 32);
                FIRE.setPosY(posY - 140);
            }
            else
            {
                FIRE.setPosX(-1000);
                FIRE.setPosY(-1000);
            }
            if(typePermission[1] == true)
            {
                AIR.setPosX(posX + 32);
                AIR.setPosY(posY - 140);
            }
            else
            {
                AIR.setPosX(-1000);
                AIR.setPosY(-1000);
            }
            if(typePermission[2] == true)
            {
                WATER.setPosX(posX - 32);
                WATER.setPosY(posY - 76);
            }
            else
            {
                WATER.setPosX(-1000);
                WATER.setPosY(-1000);
            }
            if(typePermission[3] == true)
            {
                EARTH.setPosX(posX + 32);
                EARTH.setPosY(posY - 76);
            }
            else
            {
                EARTH.setPosX(-1000);
                EARTH.setPosY(-1000);
            }
            closer.setPosX(posX + 96);
            closer.setPosY(posY - 156);
        }
        else
        {
            menu.setPosX(posX - 32);
            menu.setPosY(posY + 80);
            if(typePermission[0] == true)
            {
                FIRE.setPosX(posX - 32);
                FIRE.setPosY(posY + 80);
            }
            else
            {
                FIRE.setPosX(-1000);
                FIRE.setPosY(-1000);
            }
            if(typePermission[1] == true)
            {
                AIR.setPosX(posX + 32);
                AIR.setPosY(posY + 80);
            }
            else
            {
                AIR.setPosX(-1000);
                AIR.setPosY(-1000);
            }
            if(typePermission[2] == true)
            {
                WATER.setPosX(posX - 32);
                WATER.setPosY(posY + 144);
            }
            else
            {
                WATER.setPosX(-1000);
                WATER.setPosY(-1000);
            }
            if(typePermission[3] == true)
            {
                EARTH.setPosX(posX + 32);
                EARTH.setPosY(posY + 144);
            }
            else
            {
                EARTH.setPosX(-1000);
                EARTH.setPosY(-1000);
            }
            closer.setPosX(posX + 96);
            closer.setPosY(posY + 64);
        }
    }
    public static void close()
    {
        menu.setPosX(-1000);
        menu.setPosY(-1000);
        closer.setPosX(-1000);
        closer.setPosY(-1000);
        FIRE.setPosX(-1000);
        FIRE.setPosY(-1000);
        AIR.setPosX(-1000);
        AIR.setPosY(-1000);
        WATER.setPosX(-1000);
        WATER.setPosY(-1000);
        EARTH.setPosX(-1000);
        EARTH.setPosY(-1000);
        closer.setClicked(false);
        closer.setJustClicked(false);
        closer.imageSwap();
    }
}

