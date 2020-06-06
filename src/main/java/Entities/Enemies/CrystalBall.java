package Entities.Enemies;

import Entities.Enemy;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

public class CrystalBall extends Enemy
{
    private static final Image CRYSTALBALL = new Image("/res/entities/crystalBall.png", 16, 16, 0);
    public CrystalBall(double posX, double posY, int startDirection, int wave, int id)
    {
        super("Crystal Ball", CRYSTALBALL, posX, posY, 1, 100, 2, startDirection, wave, id, 50);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
