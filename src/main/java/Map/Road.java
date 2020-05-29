package Map;

public class Road extends Tile
{
    private int direction;
    public int waveDirection;
    public Road(String path, int posX, int posY, int width, int height, int id, int direction, int waveDirection) {
        super(path, posX, posY, width, height, id);
        this.direction = direction;
        this.waveDirection = waveDirection;
    }
    public static int startPoint(int i, int d, boolean dir[])
    {
        if((i / 16 == 0) && (dir[0] == true) && (d != 1)){
            return 3;}
        if((i % 16 == 15) && (dir[1] == true) && (d != 2)){
            return 4;}
        if((i / 16 == 8) && (dir[2] == true) && (d != 3)){
            return 1;}
        if((i % 16 == 0) && (dir[3] == true) && (d != 10)){
            return 2;}
        return 0;
    }

    public int getWaveDirection() {
        return waveDirection;
    }
}
