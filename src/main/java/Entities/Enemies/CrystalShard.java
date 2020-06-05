package Entities.Enemies;

import Entities.Enemy;
import engine.Image;

public class CrystalShard extends Enemy
{
    private static final Image CRYSTALSHARD = new Image("/res/entities/crystalShard.png", 16, 16, 0);
    public CrystalShard(double posX, double posY, int startDirection)
    {
        super(CRYSTALSHARD, posX, posY, 2, 50, 1, startDirection);
    }
}
