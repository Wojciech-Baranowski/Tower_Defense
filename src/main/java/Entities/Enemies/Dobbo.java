package Entities.Enemies;
import Entities.Enemy;
import Game.Assets;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

public class Dobbo extends Enemy
{

    public Dobbo(double posX, double posY, int startDirection, int wave, int id)
    {
        super("Dobbo", Assets.DOBBO, posX, posY, 0.75, 1000, 5, startDirection, wave, id, 200);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
