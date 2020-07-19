package engine;

import Entities.Enemy;

public interface Movable
{
    void move(int[] tileId, Enemy enemy);
}
