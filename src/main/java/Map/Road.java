package Map;

import Game.Level;
import engine.ProgramContainer;
import engine.Renderer;

public class Road extends Tile
{
    private int direction;
    private int waveDirection;
    private int positionInOrder;
    public Road(String path, double posX, double posY, int width, int height, int id, int direction, int waveDirection) {
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

    public int getDirection() {
        return direction;
    }

    public int getPositionInOrder() {
        return positionInOrder;
    }

    public void setPositionInOrder(int positionInOrder) {
        this.positionInOrder = positionInOrder;
    }

    @Override
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }

    @Override
    public void render(ProgramContainer pc, Renderer r) {

    }
}
