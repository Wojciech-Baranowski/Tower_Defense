package Game;


import Map.Road;
import Map.Tile;

public class Level
{
    private int wavesAmmount;
    private int currentWave;
    private Wave[] waves;
    private int[] tileId;
    private int[] waveDelay;
    private String[] waveInfo;
    public Level(String path)
    {
        wavesAmmount = 1;
        waveInfo = new String[wavesAmmount];
        waveDelay = new int[wavesAmmount];
        tileId = new int[]{
                0   , 0   , 0   , 0   , 0   , 0   , 113 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 0   , 0   , 0   , 0   , 113 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 123 , 124 , 124 , 124 , 114 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 113 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 113 , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
                0   , 0   , 112 , 142 , 142 , 142 , 142 , 142 , 1243, 124 , 124 , 124 , 124 , 134 , 0   , 0   ,
                0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 113 , 0   , 0   , 0   , 0   , 131 , 0   , 0   ,
                124 , 124 , 124 , 124 , 124 , 124 , 124 , 124 , 114 , 0   , 0   , 0   , 0   , 121 , 124 , 124 ,
                0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   , 0   ,
        };

        waveInfo[0] = "1x10.2x5.1x10.";
        waveDelay[0] = 10;
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
