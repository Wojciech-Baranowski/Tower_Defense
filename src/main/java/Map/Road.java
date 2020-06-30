package Map;

import Game.Assets;
import Game.Level;
import Game.Stats;
import engine.ProgramContainer;
import engine.Renderer;

public class Road extends Tile
{
    private int direction;
    private int waveDirection;
    private int positionInOrder;
    private boolean magma;
    public Road(String path, double posX, double posY, int width, int height, int id, int direction, int waveDirection) {
        super(path, posX, posY, width, height, id);
        this.direction = direction;
        this.waveDirection = waveDirection;
        this.magma = false;
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
    @Override
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {
        if(magma)
        {
            for(int i = 0; i < level.getWavesAmount(); i++)
            {
                for(int j = 0; j < level.getWaves()[i].getEnemies().length; j++)
                {
                    if(level.getWaves()[i].getEnemies()[j].isAlive())
                    {
                        if(((int)(level.getWaves()[i].getEnemies()[j].getPosX() / 64) == posX / 64) && ((int)(level.getWaves()[i].getEnemies()[j].getPosY() / 64) == posY / 64))
                        {
                            level.getWaves()[i].getEnemies()[j].healthUpdate((double)(Stats.damage[13]) / (double)(60));
                        }
                    }
                }
            }
        }
    }
    @Override
    public void render(ProgramContainer pc, Renderer r)
    {
        r.drawImage(pc, img, (int)posX, (int)posY);
        if(magma)
        r.drawImage(pc, Assets.MAGMA, (int)posX, (int)posY);
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

    public void setMagma(boolean magma) {
        this.magma = magma;
    }
}
