package Entities.Enemies;

import Entities.Enemy;
import engine.Image;

public class CrystalBall extends Enemy
{
    public CrystalBall(int posX, int posY, int startDirection)
    {
        super(new Image("/res/entities/crystalBall.png", 16, 16, 0), posX, posY, 1, 100, 2, startDirection);
    }
}
