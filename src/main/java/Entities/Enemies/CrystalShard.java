package Entities.Enemies;

import Entities.Enemy;
import engine.Image;

public class CrystalShard extends Enemy
{
    public CrystalShard(int posX, int posY, int startDirection)
    {
        super(new Image("/res/entities/crystalShard.png", 16, 16, 0), posX, posY, 2, 50, 1, startDirection);
    }
}
