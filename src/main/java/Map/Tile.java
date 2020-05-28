package Map;

import Game.UpgradeMenu;
import engine.Field;
import engine.ProgramContainer;

public class Tile extends Field
{
    public Tile(String path, int posX, int posY, int width, int height) {
        super(path, posX, posY, width, height, 0);
    }
    public static void tileInitializer(Tile[] tiles, int i, int id)
    {
        if(id == 0)
            tiles[i] = new Tile("", (i % 16) * 64, (i / 16) * 64, 64, 64);
        if((int)(id / (Math.pow(10, (int)(Math.log10(id))))) == 1)
        {
            boolean dir[] = new boolean[4];
            int d = id % 10;
            while(id > 10)
            {
                dir[id % 10 - 1] = true;
                id /= 10;
            }
            String p = "/res/road/";
            for(int j = 1; j <= 4; j++)
            {
                if(dir[j - 1] == true)
                {
                    p += j;
                }
            }
            p += ".png";
            tiles[i] = new Road(p, (i % 16) * 64, (i / 16) * 64, 64, 64, d, Road.startPoint(i, d, dir));
        }
        else if((int)(id / (Math.pow(10, (int)(Math.log10(id))))) == 2)
        {
            if(id / 10000 == 20)
            {
                boolean[] b = new boolean[4];
                if((id / 1000) % 10 == 1)
                    b[0] = true;
                else
                    b[0] = false;
                if((id / 100) % 10 == 1)
                    b[1] = true;
                else
                    b[1] = false;
                if((id / 10) % 10 == 1)
                    b[2] = true;
                else
                    b[2] = false;
                if(id % 10 == 1)
                    b[3] = true;
                else
                    b[3] = false;
                tiles[i] = new Tower("/res/towers/summoningTile.png", (i % 16) * 64, (i / 16) * 64, 64, 64, b);
            }
        }
    }
    public void update(ProgramContainer pc, Tile[] tiles)
    {
    }
}
