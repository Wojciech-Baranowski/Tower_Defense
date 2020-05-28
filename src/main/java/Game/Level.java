package Game;


import Map.Road;
import Map.Tile;
import engine.ProgramContainer;
import engine.Renderer;

public class Level
{
    private int wavesAmmount;
    private int currentWave;
    private Wave[] waves;
    private int[] wavePosition;
    private int[] tileId;
    private int[] waveDelay;
    private String[] waveInfo;
    public Level(int currentWave, int[] tileId, int[] waveDelay, String[] waveInfo, int wavesAmmount, int[] wavePosition)
    {
        this.currentWave = currentWave;
        this.tileId = tileId;
        this.waveDelay = waveDelay;
        this.waveInfo = waveInfo;
        this.wavesAmmount = wavesAmmount;
        this.wavePosition = wavePosition;
    }
    public void levelInit(Tile[] tiles)
    {
        waves = new Wave[wavesAmmount];
        for(int i = 0; i < 144; i++)
        {
            Tile.tileInitializer(tiles, i, tileId[i]);
        }
        for(int i = 0; i < wavesAmmount; i++)
        {
            if(wavePosition[i] < 16)
                waves[i] = new Wave(waveInfo[i], (wavePosition[i] % 16) * 64, (wavePosition[i] / 16) * 64 - 32, 32, (Road)tiles[wavePosition[i]]);
            else if(wavePosition[i] > 127)
                waves[i] = new Wave(waveInfo[i], (wavePosition[i] % 16) * 64, (wavePosition[i] / 16) * 64 + 32, 32, (Road)tiles[wavePosition[i]]);
            else if(wavePosition[i] % 16 == 0)
                waves[i] = new Wave(waveInfo[i], (wavePosition[i] % 16) * 64 - 32, (wavePosition[i] / 16) * 64, 32, (Road)tiles[wavePosition[i]]);
            else if(wavePosition[i] % 16 == 15)
                waves[i] = new Wave(waveInfo[i], (wavePosition[i] % 16) * 64 + 100, (wavePosition[i] / 16) * 64, 32, (Road)tiles[wavePosition[i]]);
        }
    }
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime, Stats stats)
    {
        for(int i = 0; i < 144; i++)
        {
            tiles[i].update(pc, tiles);
        }
        for(int j = 0; j < wavesAmmount; j++)
        {
            if(waves[j].isRunning())
            {
                waveStartCheck(passedTime);
                for(int i = 0; i < waves[j].getEnemies().length; i++)
                {
                    waves[j].getEnemies()[i].move(tileId);
                    if(waves[j].getEnemies()[i].hasPassed())
                    {
                        stats.setHp(stats.getHp() - waves[j].getEnemies()[i].getCost());
                    }
                }
            }
            else
                break;
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        for(int j = 0; j < wavesAmmount; j++)
        {
            for(int i = 0; i < waves[j].getEnemies().length; i++)
            {
                r.drawImage(pc, waves[j].getEnemies()[i].getImg(), waves[j].getEnemies()[i].getPosX(), waves[j].getEnemies()[i].getPosY());
            }
            for(int i = 0; i < waves[j].getEnemies().length; i++)
            {
                r.drawImage(pc, waves[j].getEnemies()[i].getHealthBar(), waves[j].getEnemies()[i].getPosX(), waves[j].getEnemies()[i].getPosY() - 6);
            }
        }
    }
    public void waveStartCheck(double passedTime)
    {
        if(wavesAmmount - 1 == currentWave)
            return;
        if(passedTime - waves[currentWave].getTimeStamp() > waveDelay[currentWave])
        {
            waveStart(passedTime);
        }
    }
    public void waveStart(double passedTime)
    {
        currentWave++;
        waves[currentWave].setTimeStamp(passedTime);
        waves[currentWave].setRunning(true);
    }
    public int getWavesAmmount() {
        return wavesAmmount;
    }

    public int getCurrentWave() {
        return currentWave;
    }

    public Wave[] getWaves() {
        return waves;
    }

    public int[] getTileId() {
        return tileId;
    }

    public String[] getWaveInfo() {
        return waveInfo;
    }

    public int[] getWaveDelay() {
        return waveDelay;
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }

    public void setWaveDelay(int[] waveDelay) {
        this.waveDelay = waveDelay;
    }

    public int[] getWavePosition() {
        return wavePosition;
    }
}
