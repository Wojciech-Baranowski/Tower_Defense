package Entities.Enemies;

import Entities.Enemy;
import Game.Assets;
import Game.EnemyStats;
import engine.ProgramContainer;
import engine.Renderer;

public class Bandit extends Enemy
{

    public Bandit(double posX, double posY, int startDirection, int wave, int id) {
        super("Bandit", Assets.BANDIT, posX, posY, EnemyStats.velocity[2], EnemyStats.hp[2], EnemyStats.armor[2], EnemyStats.cost[2], startDirection, wave, id, EnemyStats.reward[2]);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
