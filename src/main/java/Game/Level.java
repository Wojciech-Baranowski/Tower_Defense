package Game;


import Map.Road;
import Map.Tile;
import Map.TowerPlace;
import Map.Towers.FireTower;
import engine.ProgramContainer;
import engine.Renderer;

public class Level
{
    private int wavesAmount;
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
        this.wavesAmount = wavesAmmount;
        this.wavePosition = wavePosition;
    }
    public void levelInit(Tile[] tiles)
    {
        waves = new Wave[wavesAmount];
        for(int i = 0; i < 144; i++)
        {
            Tile.tileInitializer(tiles, i, tileId[i]);
        }
        roadPosition(tiles);
        for(int i = 0; i < wavesAmount; i++)
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
            if(tiles[i].getClass() == TowerPlace.class)
            {
                tiles[i].update(pc);
            }
            if(tiles[i].getClass() == FireTower.class)
            {
                tiles[i].update(pc, tiles, passedTime, this);
            }
            else
            {
                tiles[i].update(pc, tiles, passedTime);
            }

        }
        for(int j = 0; j < wavesAmount; j++)
        {
            if(waves[j].isRunning())
            {
                waveStartCheck(passedTime);
                for(int i = 0; i < waves[j].getEnemies().length; i++)
                {
                    waves[j].getEnemies()[i].move(tileId);
                    if(waves[j].getEnemies()[i].hasPassed())
                    {
                        Stats.hp -= waves[j].getEnemies()[i].getCost();
                    }
                }
            }
            else
                break;
        }
    }
    public void render(ProgramContainer pc, Renderer r)
    {
        for(int j = 0; j < wavesAmount; j++)
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
        if(wavesAmount - 1 == currentWave)
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

    private void roadPosition(Tile[] tiles)
    {
        int out = 0;
        for(int i = 0; i < 144; i++)
        {
            if(tiles[i].getClass() == Road.class)
            {
                if((i / 16 == 0) && (((Road)(tiles[i])).getDirection() == 1))
                {
                    out = i;
                    break;
                }
                if((i % 16 == 15) && (((Road)(tiles[i])).getDirection() == 2))
                {
                    out = i;
                    break;
                }
                if((i / 16 == 8) && (((Road)(tiles[i])).getDirection() == 3))
                {
                    out = i;
                    break;
                }
                if((i % 16 == 0) && (((Road)(tiles[i])).getDirection() == 4))
                {
                    out = i;
                    break;
                }
            }
        }

    }

    public int getWavesAmount() {
        return wavesAmount;
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
