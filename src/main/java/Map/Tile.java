package Map;

import Game.Level;
import engine.Field;
import engine.ProgramContainer;
import engine.Renderer;

public abstract class Tile extends Field
{
    protected int id;
    public Tile(String path, int posX, int posY, int width, int height, int id) {
        super(path, posX, posY, width, height, 0);
        this.id = id;
    }
    public static void tileInitializer(Tile[] tiles, int i, int id)
    {
        if(id == 0)
            tiles[i] = new BackgroundTile("", (i % 16) * 64, (i / 16) * 64, 64, 64, i);
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
            tiles[i] = new Road(p, (i % 16) * 64, (i / 16) * 64, 64, 64, i, d, Road.startPoint(i, d, dir));
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
                tiles[i] = new TowerPlace("/res/towers/summoningTile.png", (i % 16) * 64, (i / 16) * 64, 64, 64, i, b);
            }
        }
    }
    public abstract void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level);
    public abstract void render(ProgramContainer pc, Renderer r);
}
