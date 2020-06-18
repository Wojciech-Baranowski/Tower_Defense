package Map;

import Game.Assets;
import Game.gui.BasicUpgradeMenu;
import Game.gui.BuildMenu;
import Game.Level;
import engine.*;

public class TowerPlace extends Tile implements Clickable
{
    boolean[] typePermission;
    public TowerPlace(Image img, double posX, double posY, int id, boolean[] typePermission)
    {
        super(img, posX, posY, id);
        this.typePermission = typePermission;
        if(typePermission[0] == true)
        {
            for(int i = 0; i < 32; i++)
            {
                for(int j = 0; j < 32; j++)
                {
                    if(Assets.FIREM.getP()[i * 32 + j] != 0xFFFF00FF)
                    {
                        img.getP()[i * 64 + j] = Assets.FIREM.getP()[i * 32 + j];
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
                    if(Assets.AIRM.getP()[i * 32 + j - 32] != 0xFFFF00FF)
                    {
                        img.getP()[i * 64 + j] = Assets.AIRM.getP()[i * 32 + j - 32];
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
                    if(Assets.WATERM.getP()[(i - 32) * 32 + j] != 0xFFFF00FF)
                    {
                        img.getP()[i * 64 + j] = Assets.WATERM.getP()[(i - 32) * 32 + j];
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
                    if(Assets.EARTHM.getP()[(i - 32) * 32 + j - 32] != 0xFFFF00FF)
                    {
                        img.getP()[i * 64 + j] = Assets.EARTHM.getP()[(i - 32) * 32 + j - 32];
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
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawImage(pc, img, (int)posX, (int)posY);
    }

    public boolean[] getTypePermission() {
        return typePermission;
    }

    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if((this.isClick(pc, this.posX, this.posY, this.img.getW(), this.img.getH())) && (!BuildMenu.MENU.inBorder(pc, BuildMenu.MENU.getPosX(), BuildMenu.MENU.getPosY(), BuildMenu.MENU.getImg().getW(), BuildMenu.MENU.getImg().getH())) && (!BasicUpgradeMenu.MENU.inBorder(pc, BasicUpgradeMenu.MENU.getPosX(), BasicUpgradeMenu.MENU.getPosY(), BasicUpgradeMenu.MENU.getImg().getW(), BasicUpgradeMenu.MENU.getImg().getH())))
        {
            BasicUpgradeMenu.close();
            BuildMenu.open(posX, posY, id, typePermission);
        }
    }
}
