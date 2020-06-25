package Game;

import Map.Road;
import Map.Tile;
import Map.Towers.AdvancedAirTower;
import Map.Towers.AdvancedFireTower;
import Map.Towers.AirTower;
import Map.Towers.MasterAirTower;
import engine.*;

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
                waves[i] = new Wave(waveInfo[i], (wavePosition[i] % 16) * 64, (wavePosition[i] / 16) * 64 - 32, 32, (Road)tiles[wavePosition[i]], i);
            else if(wavePosition[i] > 127)
                waves[i] = new Wave(waveInfo[i], (wavePosition[i] % 16) * 64, (wavePosition[i] / 16) * 64 + 32, 32, (Road)tiles[wavePosition[i]], i);
            else if(wavePosition[i] % 16 == 0)
                waves[i] = new Wave(waveInfo[i], (wavePosition[i] % 16) * 64 - 32, (wavePosition[i] / 16) * 64, 32, (Road)tiles[wavePosition[i]], i);
            else if(wavePosition[i] % 16 == 15)
                waves[i] = new Wave(waveInfo[i], (wavePosition[i] % 16) * 64 + 100, (wavePosition[i] / 16) * 64, 32, (Road)tiles[wavePosition[i]], i);
        }
    }
    public void update(ProgramContainer pc, Tile[] tiles, double passedTime)
    {
        for(int i = 0; i < 144; i++)
        {
            tiles[i].update(pc, tiles, passedTime, this);
        }
        for(int j = 0; j < wavesAmount; j++)
        {
            if(waves[j].isRunning())
            {
                waveStartCheck(passedTime);
                for(int i = 0; i < waves[j].getEnemies().length; i++)
                {
                    waves[j].getEnemies()[i].update(pc, passedTime, this);
                }
            }
            else
                break;
        }
    }
    public void render(ProgramContainer pc, Renderer r, Tile[] tiles)
    {
        for(int i = 0; i < 144; i++)
        {
            if(tiles[i].getClass() == Road.class)
            tiles[i].render(pc, r);
        }
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() != Road.class) && (tiles[i].getClass() != AirTower.class) && (tiles[i].getClass() != AdvancedAirTower.class) && (tiles[i].getClass() != AdvancedAirTower.class))
            tiles[i].render(pc, r);
        }
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == AirTower.class) || (tiles[i].getClass() == AdvancedAirTower.class) || (tiles[i].getClass() == MasterAirTower.class))
                tiles[i].render(pc, r);
        }
        for(int j = 0; j < wavesAmount; j++)
        {
            for(int i = 0; i < waves[j].getEnemies().length; i++)
            {
                waves[j].getEnemies()[i].render(pc, r);
            }
            for(int i = 0; i < waves[j].getEnemies().length; i++)
            {
                waves[j].getEnemies()[i].healthBarRender(pc, r);
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
        ((Road)(tiles[out])).setPositionInOrder(0);
        roadCheck(tiles, out);
    }
    void roadCheck(Tile[] tiles, int id)
    {
        if(tiles[id].getClass() == Road.class)
        {
            if((id / 16 > 0) && (tiles[id - 16].getClass() == Road.class) && (((Road)(tiles[id - 16])).getDirection() == 3))
            {
                ((Road)(tiles[id - 16])).setPositionInOrder(((Road)(tiles[id])).getPositionInOrder() + 1);
                roadCheck(tiles, id - 16);
            }
            if((id % 16 != 15) && (tiles[id + 1].getClass() == Road.class) && (((Road)(tiles[id + 1])).getDirection() == 4))
            {
                ((Road)(tiles[id + 1])).setPositionInOrder(((Road)(tiles[id])).getPositionInOrder() + 1);
                roadCheck(tiles, id + 1);
            }
            if((id / 16 < 8) && (tiles[id + 16].getClass() == Road.class) && (((Road)(tiles[id + 16])).getDirection() == 1))
            {
                ((Road)(tiles[id + 16])).setPositionInOrder(((Road)(tiles[id])).getPositionInOrder() + 1);
                roadCheck(tiles, id + 16);
            }
            if((id % 16 != 0) && (tiles[id - 1].getClass() == Road.class) && (((Road)(tiles[id - 1])).getDirection() == 2))
            {
                ((Road)(tiles[id - 1])).setPositionInOrder(((Road)(tiles[id])).getPositionInOrder() + 1);
                roadCheck(tiles, id - 1);
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

    public int[] getWaveDelay() {
        return waveDelay;
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }

}
