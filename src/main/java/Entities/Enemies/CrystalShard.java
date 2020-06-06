package Entities.Enemies;

import Entities.Enemy;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

public class CrystalShard extends Enemy
{
    private static final Image CRYSTALSHARD = new Image("/res/entities/crystalShard.png", 16, 16, 0);
    public CrystalShard(double posX, double posY, int startDirection, int wave, int id)
    {
        super("Crystal Shard", CRYSTALSHARD, posX, posY, 2, 50, 1, startDirection, wave, id, 25);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
