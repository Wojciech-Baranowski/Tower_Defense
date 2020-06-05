package Entities.Enemies;

import Entities.Enemy;
import engine.Image;

public class CrystalBall extends Enemy
{
    private static final Image CRYSTALBALL = new Image("/res/entities/crystalBall.png", 16, 16, 0);
    public CrystalBall(double posX, double posY, int startDirection)
    {
        super(CRYSTALBALL, posX, posY, 1, 100, 2, startDirection);
    }
}
