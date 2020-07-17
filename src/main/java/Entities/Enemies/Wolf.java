package Entities.Enemies;

import Entities.Enemy;
import Entities.EnemyImageSheet;
import Game.Assets;
import Game.EnemyStats;
import engine.ProgramContainer;
import engine.Renderer;

public class Wolf extends Enemy
{

    public Wolf(double posX, double posY, int startDirection, int wave, int id) {
        super("Wolf", Assets.WOLF, posX, posY, EnemyStats.velocity[1], EnemyStats.hp[1], EnemyStats.armor[1], EnemyStats.cost[1], startDirection, wave, id, EnemyStats.reward[1]);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
