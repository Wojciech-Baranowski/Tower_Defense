package Map;

public class Tower extends Tile
{
    private int upgradeLvl;
    public Tower(String path, int posX, int posY, int width, int height, int id, int upgradeLvl) {
        super(path, posX, posY, width, height, id);
        this.upgradeLvl = upgradeLvl;
    }
}
