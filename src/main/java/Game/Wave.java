package Game;

import Entities.Enemies.*;
import Entities.Enemy;
import Map.Road;

public class Wave
{
    private Enemy[] enemies;
    private double posX;
    private double posY;
    private double timeStamp;
    private int unitDistance;
    private Road startPoint;
    private boolean isRunning;
    private int id;
    public Wave(String info, double posX, double posY, int unitDistance, Road startPoint, int id)
    {
        this.posX = posX;
        this.posY = posY;
        this.unitDistance = unitDistance;
        this.startPoint = startPoint;
        this.timeStamp = 0;
        this.isRunning = false;
        this.id = id;
        decryptor(info);
    }
    private void decryptor(String info)
    {
        char[] c;
        c = info.toCharArray();
        int n = 0;
        int j = 0;
        int m = 1;
        for(int i = 0; i < info.length(); i++)
        {
            if(c[i] == '.')
            {
                n++;
            }
            if(c[i] == 'x')
            {
                m = 0;
                i++;
                while(c[i] != '.')
                {
                    m = m * 10 + c[i] - '0';
                    i++;
                }
                n += m;
            }
        }
        enemies = new Enemy[n];
        n = c[0] - '0';
        for(int i = 1; i < info.length(); i++)
        {
            m = 1;
            if(c[i] == 'x')
            {
                m = 0;
                i++;
                while(c[i] != '.')
                {
                    m = m * 10 + c[i] - '0';
                    i++;
                }
            }
            if(c[i] == '.')
            {
                if(n > 0)
                {
                    for(int k = 0; k < m; k++)
                    {
                        makeUnitSpace();
                        if(n == 1)
                            enemies[j++] = new Peasant(posX + (int)(System.nanoTime()) % 8 + 16, posY + (int)(System.nanoTime()) % 8 + 16, startPoint.getWaveDirection(), id, j - 1);
                        if(n == 2)
                            enemies[j++] = new Wolf(posX + (int)(System.nanoTime()) % 16 + 16, posY + (int)(System.nanoTime()) % 16 + 16, startPoint.getWaveDirection(), id, j - 1);
                        if(n == 3)
                            enemies[j++] = new Bandit(posX + (int)(System.nanoTime()) % 8 + 8, posY + (int)(System.nanoTime()) % 8 + 8, startPoint.getWaveDirection(), id, j - 1);
                        if(n == 4)
                            enemies[j++] = new Knight(posX + (int)(System.nanoTime()) % 8 + 8, posY + (int)(System.nanoTime()) % 8 + 8, startPoint.getWaveDirection(), id, j - 1);
                        if(n == 5)
                            enemies[j++] = new Berserker(posX + (int)(System.nanoTime()) % 8 + 8, posY + (int)(System.nanoTime()) % 8 + 8, startPoint.getWaveDirection(), id, j - 1);
                    }
                }
                n = 0;
            }
            else
                n = n * 10 + c[i] - '0';
        }
    }
    private void makeUnitSpace()
    {
        if(startPoint.getWaveDirection() == 1)
            posY += unitDistance;
        if(startPoint.getWaveDirection() == 2)
            posX -= unitDistance;
        if(startPoint.getWaveDirection() == 3)
            posY -= unitDistance;
        if(startPoint.getWaveDirection() == 4)
            posX += unitDistance;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(double timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

}
