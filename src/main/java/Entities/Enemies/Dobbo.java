package Entities.Enemies;
import Entities.Enemy;
import engine.Image;

public class Dobbo extends Enemy
{
    public static final Image DOBBO = new Image("/res/entities/dobbo.png", 32, 32, 0);
    public Dobbo(double posX, double posY, int startDirection)
    {
        super(DOBBO, posX, posY, 0.75, 1000, 5, startDirection);
    }
}
