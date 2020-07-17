package Entities.Enemies;

import Entities.Enemy;
import Entities.EnemyImageSheet;
import Game.Assets;
import engine.ProgramContainer;
import engine.Renderer;

public class Peasant extends Enemy
{

    public Peasant(double posX, double posY, int startDirection, int wave, int id) {
        super("Peasant", Assets.PEASANT, posX, posY, 2, 100, 1, startDirection, wave, id, 10);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
