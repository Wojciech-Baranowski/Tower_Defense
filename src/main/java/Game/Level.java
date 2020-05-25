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
    private int[] tileId;
    private int[] waveDelay;
    private String[] waveInfo;
    public Level(int currentWave, int[] tileId, int[] waveDelay, String[] waveInfo, int wavesAmmount)
    {
        this.currentWave = currentWave;
        this.tileId = tileId;
        this.waveDelay = waveDelay;
        this.waveInfo = waveInfo;
        this.wavesAmmount = wavesAmmount;
    }
    public void update(double passedTime, Stats stats)
    {
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
                        System.out.println(stats.getHp());
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
    public void levelInit(Tile[] tiles)
    {
        currentWave = 0;
        waves = new Wave[wavesAmmount];
        for(int i = 0; i < 144; i++)
        {
            Tile.tileInitializer(tiles, i, tileId[i]);
        }
        for(int i = 0; i < wavesAmmount; i++)
        {
            waves[i] = new Wave(waveInfo[i], 6 * 64, 0, 32, (Road)tiles[6]);
        }
        waves[0].setRunning(true);
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
}
