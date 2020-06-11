package Map;

import Game.Level;
import engine.ProgramContainer;
import engine.Renderer;

public class BackgroundTile extends Tile
{
    public BackgroundTile(String path, double posX, double posY, int width, int height, int id)
    {
        super(path, posX, posY, width, height, id);
    }

    @Override
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }

    @Override
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawImage(pc, img, (int)posX, (int)posY);
    }
}
