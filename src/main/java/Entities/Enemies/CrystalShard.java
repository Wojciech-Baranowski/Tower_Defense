package Entities.Enemies;

import Entities.Enemy;
import Game.Assets;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

public class CrystalShard extends Enemy
{

    public CrystalShard(double posX, double posY, int startDirection, int wave, int id)
    {
        super("Crystal Shard", Assets.DEFAULTENEMY, posX, posY, 2, 50, 1, startDirection, wave, id, 25);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
