package Map.Towers;

import Entities.Enemy;
import Entities.Particles.Bullets.FireBullet;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import engine.*;

public class LightingTower extends Tower
{
    private double prevX;
    private double prevY;
    public LightingTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.LIGHTINGTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
        prevX = -1;
        prevY = -1;
    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r) {

    }

    @Override
    public void fire(Level level, Tile[] tiles, double passedTime)
    {
            Pair enemyId = targetChoose(level, tiles);
            if(enemyId.first >= 0)
            {
                if((prevX != -1) && (prevY != -1))
                lightingBolt(level, enemyId.first, enemyId.second, posX + 32, posY, prevX, prevY, 0xFFFF00FF);
                lightingBolt(level, enemyId.first, enemyId.second, posX + 32, posY, level.getWaves()[enemyId.first].getEnemies()[enemyId.second].getPosX() + 8, level.getWaves()[enemyId.first].getEnemies()[enemyId.second].getPosY() + 4, 0xFF700DDD);
                prevX = level.getWaves()[enemyId.first].getEnemies()[enemyId.second].getPosX() + 8;
                prevY = level.getWaves()[enemyId.first].getEnemies()[enemyId.second].getPosY() + 4;
            }
            else
            {
                if((prevX != -1) && (prevY != -1))
                {
                    Geometry.line((int)posX + 32, (int)posY, (int)prevX, (int)prevY, 3, 0xFFFF00FF);
                    prevX = -1;
                    prevY = -1;
                }
            }
    }
    private void lightingBolt(Level level, int waveId, int enemyId, double x1, double y1, double x2, double y2, int color)
    {
        Geometry.line((int)x1, (int)y1, (int)x2, (int)y2, 3, color);
        level.getWaves()[waveId].getEnemies()[enemyId].healthUpdate((double)(Stats.damage[12]) / (double)(60));
    }
}
