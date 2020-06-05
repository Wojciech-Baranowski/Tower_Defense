package Map;

import Game.BuildMenu;
import Game.Level;
import engine.Button;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

public class TowerPlace extends Tile
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
                        img2.getP()[i * 64 + j] = FIRE.getP()[i * 32 + j];
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
                        img2.getP()[i * 64 + j] = AIR.getP()[i * 32 + j - 32];
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
                        img2.getP()[i * 64 + j] = WATER.getP()[(i - 32) * 32 + j];
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
                        img2.getP()[i * 64 + j] = EARTH.getP()[(i - 32) * 32 + j - 32];
                    }
                }
            }
        }
    }
    @Override
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {
        this.holdClick(pc);
        if(this.isJustClicked())
        {
            BuildMenu.open(posX, posY, id, typePermission);
        }
    }

    @Override
    public void render(ProgramContainer pc, Renderer r) {

    }

    public boolean[] getTypePermission() {
        return typePermission;
    }
}
