package Map;

import Game.gui.BasicUpgradeMenu;
import Game.gui.BuildMenu;
import Game.Level;
import engine.*;

public class TowerPlace extends Tile implements Clickable
{
    private static final Image FIRE = new Image("/res/towers/summoningTileFire.png", 32, 32, 0);
    private static final Image AIR = new Image("/res/towers/summoningTileAir.png", 32, 32, 0);
    private static final Image WATER = new Image("/res/towers/summoningTileWater.png", 32, 32, 0);
    private static final Image EARTH = new Image("/res/towers/summoningTileEarth.png", 32, 32, 0);
    boolean[] typePermission;
    public TowerPlace(String path, double posX, double posY, int width, int height, int id, boolean[] typePermission)
    {
        super(path, posX, posY, width, height, id);
        this.typePermission = typePermission;
        if(typePermission[0] == true)
        {
            for(int i = 0; i < 32; i++)
            {
                for(int j = 0; j < 32; j++)
                {
                    if(FIRE.getP()[i * 32 + j] != 0xFFFF00FF)
                    {
                        img.getP()[i * 64 + j] = FIRE.getP()[i * 32 + j];
                    }
                }
            }
        }
        if(typePermission[1] == true)
        {
            for(int i = 0; i < 32; i++)
            {
                for(int j = 32; j < 64; j++)
                {
                    if(AIR.getP()[i * 32 + j - 32] != 0xFFFF00FF)
                    {
                        img.getP()[i * 64 + j] = AIR.getP()[i * 32 + j - 32];
                    }
                }
            }
        }
        if(typePermission[2] == true)
        {
            for(int i = 32; i < 64; i++)
            {
                for(int j = 0; j < 32; j++)
                {
                    if(WATER.getP()[(i - 32) * 32 + j] != 0xFFFF00FF)
                    {
                        img.getP()[i * 64 + j] = WATER.getP()[(i - 32) * 32 + j];
                    }
                }
            }
        }
        if(typePermission[3] == true)
        {
            for(int i = 32; i < 64; i++)
            {
                for(int j = 32; j < 64; j++)
                {
                    if(EARTH.getP()[(i - 32) * 32 + j - 32] != 0xFFFF00FF)
                    {
                        img.getP()[i * 64 + j] = EARTH.getP()[(i - 32) * 32 + j - 32];
                    }
                }
            }
        }
    }
    @Override
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {
        onClick(pc, this.posX, this.posY, this.img.getW(), this.img.getH());
    }

    @Override
    public void render(ProgramContainer pc, Renderer r) {

    }

    public boolean[] getTypePermission() {
        return typePermission;
    }

    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if((this.isClick(pc, this.posX, this.posY, this.img.getW(), this.img.getH())) && (!BuildMenu.menu.inBorder(pc, BuildMenu.menu.getPosX(), BuildMenu.menu.getPosY(), BuildMenu.menu.getImg().getW(), BuildMenu.menu.getImg().getH())) && (!BasicUpgradeMenu.menu.inBorder(pc, BasicUpgradeMenu.menu.getPosX(), BasicUpgradeMenu.menu.getPosY(), BasicUpgradeMenu.menu.getImg().getW(), BasicUpgradeMenu.menu.getImg().getH())))
        {
            BasicUpgradeMenu.close();
            BuildMenu.open(posX, posY, id, typePermission);
        }
    }
}
