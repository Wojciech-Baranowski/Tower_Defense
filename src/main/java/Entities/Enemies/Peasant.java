package Entities.Enemies;

import Entities.Enemy;
import Game.Assets;
import Game.EnemyStats;
import engine.ProgramContainer;
import engine.Renderer;

public class Peasant extends Enemy
{

    public Peasant(double posX, double posY, int startDirection, int wave, int id) {
        super("Peasant", Assets.PEASANT, posX, posY, EnemyStats.velocity[0], EnemyStats.hp[0], EnemyStats.armor[0], EnemyStats.cost[0], startDirection, wave, id, EnemyStats.reward[0]);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
