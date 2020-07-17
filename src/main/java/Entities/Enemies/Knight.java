package Entities.Enemies;

import Entities.Enemy;
import Entities.EnemyImageSheet;
import Game.Assets;
import Game.EnemyStats;
import engine.ProgramContainer;
import engine.Renderer;

public class Knight extends Enemy
{

    public Knight(double posX, double posY, int startDirection, int wave, int id) {
        super("Knight", Assets.KNIGHT, posX, posY, EnemyStats.velocity[3], EnemyStats.hp[3], EnemyStats.armor[3], EnemyStats.cost[3], startDirection, wave, id, EnemyStats.reward[3]);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
