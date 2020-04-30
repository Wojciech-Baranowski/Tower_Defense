package Game;

import Entities.Enemies.CrystalShard;
import Entities.Enemy;

public class Wave
{
    private Enemy[] enemies;
    public Wave(String info, int posX, int posY)
    {

    }
    private void decryptor(String info, int posX, int posY)
    {
        char[] c;
        c = info.toCharArray();
        int n = 0;
        int j = 0;
        for(int i = 0; i < info.length(); i++)
        {
            if(c[i] == '.')
            {
                n++;
            }
        }
        enemies = new Enemy[n];
        n = c[0];
        for(int i = 1; i < info.length(); i++)
        {
            if(c[i] == '.')
            {
                enemies[j++] = new CrystalShard(32, 32);
                n = 0;
            }
            else
                n *= 10 + c[i] - '0';
        }
    }
}
