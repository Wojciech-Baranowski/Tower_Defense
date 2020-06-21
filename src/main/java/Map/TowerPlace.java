package Map;

import Game.Assets;
import Game.gui.AdvancedUpgradeMenu;
import Game.gui.BasicUpgradeMenu;
import Game.gui.BuildMenu;
import Game.Level;
import engine.*;

public class TowerPlace extends Tile implements Clickable
{
    boolean[] typePermission;
    Image[] elementals;
    public TowerPlace(Image img, double posX, double posY, int id, boolean[] typePermission)
    {
        super(img, posX, posY, id);
        elementals = new Image[4];
        this.typePermission = typePermission;
        if(typePermission[0] == true)
        {
            elementals[0] = Assets.FIRE32;
        }
        else
        {
            elementals[0] = Assets.BLANK;
        }
        if(typePermission[1] == true)
        {
            elementals[1] = Assets.AIR32;
        }
        else
        {
            elementals[1] = Assets.BLANK;
        }
        if(typePermission[2] == true)
        {
            elementals[2] = Assets.WATER32;
        }
        else
        {
            elementals[2] = Assets.BLANK;
        }
        if(typePermission[3] == true)
        {
            elementals[3] = Assets.EARTH32;
        }
        else
        {
            elementals[3] = Assets.BLANK;
        }
    }
    @Override
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {
        img = Assets.SUMMONINGTILEANIMA.updateLoop(img, World.tickCount);
        if(typePermission[0])
            elementals[0] = Assets.FIREANIMA32.updateLoop(elementals[0], World.tickCount);
        if(typePermission[1])
            elementals[1] = Assets.AIRANIMA32.updateLoop(elementals[1], World.tickCount);
        if(typePermission[2])
            elementals[2] = Assets.WATERANIMA32.updateLoop(elementals[2], World.tickCount);
        if(typePermission[3])
            elementals[3] = Assets.EARTHANIMA32.updateLoop(elementals[3], World.tickCount);
        onClick(pc, this.posX, this.posY, this.img.getW(), this.img.getH());
    }

    @Override
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawImage(pc, img, (int)posX, (int)posY);
        r.drawImage(pc, elementals[0], (int)posX + 16, (int)posY + 12);
        r.drawImage(pc, elementals[1], (int)posX - 4, (int)posY + 16);
        r.drawImage(pc, elementals[2], (int)posX + 34, (int)posY + 16);
        r.drawImage(pc, elementals[3], (int)posX + 16, (int)posY + 28);
    }

    public boolean[] getTypePermission() {
        return typePermission;
    }

    @Override
    public void onClick(ProgramContainer pc, double posX, double posY, int width, int height)
    {
        if((this.isClick(pc, this.posX, this.posY, this.img.getW(), this.img.getH())) && (!BuildMenu.MENU.inBorder(pc, BuildMenu.MENU.getPosX(), BuildMenu.MENU.getPosY(), BuildMenu.MENU.getImg().getW(), BuildMenu.MENU.getImg().getH())) && (!BasicUpgradeMenu.MENU.inBorder(pc, BasicUpgradeMenu.MENU.getPosX(), BasicUpgradeMenu.MENU.getPosY(), BasicUpgradeMenu.MENU.getImg().getW(), BasicUpgradeMenu.MENU.getImg().getH())) && (!AdvancedUpgradeMenu.MENU.inBorder(pc, AdvancedUpgradeMenu.MENU.getPosX(), AdvancedUpgradeMenu.MENU.getPosY(), AdvancedUpgradeMenu.MENU.getImg().getW(), AdvancedUpgradeMenu.MENU.getImg().getH())))
        {
            BasicUpgradeMenu.close();
            AdvancedUpgradeMenu.close();
            BuildMenu.open(posX, posY, id, typePermission);
        }
    }
}
