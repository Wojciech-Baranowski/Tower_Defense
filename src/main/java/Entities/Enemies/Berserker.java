package Entities.Enemies;

import Entities.Enemy;
import Entities.EnemyImageSheet;
import Game.Assets;
import Game.EnemyStats;
import engine.ProgramContainer;
import engine.Renderer;

public class Berserker extends Enemy
{

    public Berserker(double posX, double posY, int startDirection, int wave, int id) {
        super("Berserker", Assets.BERSERKER, posX, posY, EnemyStats.velocity[4], EnemyStats.hp[4], EnemyStats.armor[4], EnemyStats.cost[4], startDirection, wave, id, EnemyStats.reward[4]);
    }

    @Override
    public void indUpdate(ProgramContainer pc, double passedTime) {

    }

    @Override
    public void indrender(ProgramContainer pc, Renderer r) {

    }
}
