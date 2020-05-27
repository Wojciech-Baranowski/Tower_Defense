package Game;

public class Stats
{
    private int hp;
    private int fire;
    private int water;
    private int air;
    private int earth;
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public int getEarth() {
        return earth;
    }

    public void setEarth(int earth) {
        this.earth = earth;
    }
}
