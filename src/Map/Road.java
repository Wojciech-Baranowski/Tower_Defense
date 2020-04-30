package Map;

public class Road extends Tile
{
    private int direction;
    public Road(String path, int posX, int posY, int width, int height, int direction) {
        super(path, posX, posY, width, height);
        this.direction = direction;
    }
}
