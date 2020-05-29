package Game;

public class Stats
{
    public static int hp;
    public static int fire;
    public static int water;
    public static int air;
    public static int earth;
    public Stats(int hp, int fire, int water, int earth, int air)
    {
        this.hp = hp;
        this.fire = fire;
        this.water = water;
        this.air = air;
        this.earth = earth;
    }
    public int getHp() {
        return hp;
    }

    public int getFire() {
        return fire;
    }

    public int getWater() {
        return water;
    }

    public int getAir() {
        return air;
    }

    public int getEarth() {
        return earth;
    }

}
