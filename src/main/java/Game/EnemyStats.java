package Game;

public class EnemyStats
{
    public static int[] hp;
    public static int[] size;
    public static double[] velocity;
    public static double[] armor;
    public static int[] cost;
    public static int[] reward;

    public EnemyStats(int[] hp, int[] size, double[] velocity, double[] armor, int[] cost, int[] reward)
    {
        this.hp = hp;
        this.size = size;
        this.velocity = velocity;
        this.armor = armor;
        this.cost = cost;
        this.reward = reward;
    }

    public static int[] getHp() {
        return hp;
    }

    public static int[] getSize() {
        return size;
    }

    public static double[] getVelocity() {
        return velocity;
    }

    public static double[] getArmor() {
        return armor;
    }

    public static int[] getCost() {
        return cost;
    }

    public static int[] getReward() {
        return reward;
    }
}
