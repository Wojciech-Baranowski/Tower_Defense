package Entities.Enemies;
import Entities.Enemy;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

public class Dobbo extends Enemy
{
    public static final Image DOBBO = new Image("/res/entities/dobbo.png", 32, 32, 0);
    public Dobbo(double posX, double posY, int startDirection, int wave, int id)
    {
        super("Dobbo", DOBBO, posX, posY, 0.75, 1000, 5, startDirection, wave, id, 200);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
