package Map;

import engine.Field;

public class Tile extends Field
{
    public Tile(String path, int posX, int posY, int width, int height) {
        super(path, posX, posY, width, height, 0);
    }
}
