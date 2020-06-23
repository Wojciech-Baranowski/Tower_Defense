package Game;

public class Stats
{
    //TODO: add masters, finish towers, finish advanced upgrade menu
    public static int hp;
    public static int[] resources;
    public static int[] damage;
    public static int[] range;
    public static int[] bulletVelocity;
    public static double[] fireDelay;
    public static double[] airAttackSpeedBoost;
    public static double[] airRangeBoost;
    public static int[] earthSplashRange;
    public static double[] earthSplashDmgPercentage;

    public Stats(int hp, int[] resources, int[] damage, int[] range, int[] bulletVelocity, double[] fireDelay, double[] airAttackSpeedBoost, double[] airRangeBoost, int[] earthSplashRange, double[] earthSplashDmgPercentage)
    {
        this.hp = hp;
        this.resources = resources;
        this.damage = damage;
        this.range = range;
        this.bulletVelocity = bulletVelocity;
        this.fireDelay = fireDelay;
        this.airAttackSpeedBoost = airAttackSpeedBoost;
        this.airRangeBoost = airRangeBoost;
        this.earthSplashRange = earthSplashRange;
        this.earthSplashDmgPercentage = earthSplashDmgPercentage;
    }

    public static void splitReward(int reward)
    {
        for(int i = 0; i < reward; i++)
        {
            if((int)(Math.random() * 100) % 4 == 0)
            {
                resources[0]++;
            }
            else if((int)(Math.random() * 100) % 4 == 1)
            {
                resources[1]++;
            }
            else if((int)(Math.random() * 100) % 4 == 2)
            {
                resources[2]++;
            }
            else if((int)(Math.random() * 100) % 4 == 3)
            {
                resources[3]++;
            }
        }
    }

    public static int getHp() {
        return hp;
    }

    public static int[] getResources() {
        return resources;
    }

    public static int[] getDamage() {
        return damage;
    }

    public static int[] getRange() {
        return range;
    }

    public static int[] getBulletVelocity() {
        return bulletVelocity;
    }

    public static double[] getFireDelay() {
        return fireDelay;
    }

    public static double[] getAirAttackSpeedBoost() {
        return airAttackSpeedBoost;
    }

    public static double[] getAirRangeBoost() {
        return airRangeBoost;
    }

    public static int[] getEarthSplashRange() {
        return earthSplashRange;
    }

    public static double[] getEarthSplashDmgPercentage() {
        return earthSplashDmgPercentage;
    }
}
