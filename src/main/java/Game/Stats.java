package Game;

public class Stats
{
    public static int hp;
    public static int fire;
    public static int air;
    public static int water;
    public static int earth;
    public static int fireDmg;
    public static int waterDmg;
    public static int earthDmg;
    public static int fireRange;
    public static int airRange;
    public static int waterRange;
    public static int earthRange;
    public static int fireBulletVelocity;
    public static int waterBulletVelocity;
    public static int earthBulletVelocity;
    public static double fireFireDelay;
    public static double waterFireDelay;
    public static double earthFireDelay;
    public static double airAttackSpeedBoost;
    public static double airRangeBoost;
    public static int earthSplashRange;
    public static double earthSplashDmgPercentage;
    public Stats(int hp, int fire, int water, int earth, int air, int fireDmg, int waterDmg, int earthDmg, int fireRange, int airRange, int waterRange, int earthRange, int fireBulletVelocity, int waterBulletVelocity, int earthBulletVelocity, double fireFireDelay, double waterFireDelay, double earthFireDelay, double airAttackSpeedBoost, double airRangeBoost, int earthSplashRange, double earthSplashDmgPercentage)
    {
        this.hp = hp;
        this.fire = fire;
        this.water = water;
        this.air = air;
        this.earth = earth;
        this.fireDmg = fireDmg;
        this.waterDmg = waterDmg;
        this.earthDmg = earthDmg;
        this.fireRange = fireRange;
        this.airRange = airRange;
        this.waterRange = waterRange;
        this.earthRange = earthRange;
        this.fireBulletVelocity = fireBulletVelocity;
        this.waterBulletVelocity = waterBulletVelocity;
        this.earthBulletVelocity = earthBulletVelocity;
        this.fireFireDelay = fireFireDelay;
        this.waterFireDelay = waterFireDelay;
        this.earthFireDelay = earthFireDelay;
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
                fire++;
            }
            else if((int)(Math.random() * 100) % 4 == 1)
            {
                air++;
            }
            else if((int)(Math.random() * 100) % 4 == 2)
            {
                water++;
            }
            else if((int)(Math.random() * 100) % 4 == 3)
            {
                earth++;
            }
        }
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

    public static int getFireDmg() {
        return fireDmg;
    }

    public static int getWaterDmg() {
        return waterDmg;
    }

    public static int getEarthDmg() {
        return earthDmg;
    }

    public static int getFireRange() {
        return fireRange;
    }

    public static int getAirRange() {
        return airRange;
    }

    public static int getWaterRange() {
        return waterRange;
    }

    public static int getEarthRange() {
        return earthRange;
    }

    public static int getEarthSplashRange() {
        return earthSplashRange;
    }

    public static double getEarthSplashDmgPercentage() {
        return earthSplashDmgPercentage;
    }

    public static int getFireBulletVelocity() {
        return fireBulletVelocity;
    }

    public static int getWaterBulletVelocity() {
        return waterBulletVelocity;
    }

    public static int getEarthBulletVelocity() {
        return earthBulletVelocity;
    }

    public static double getFireFireDelay() {
        return fireFireDelay;
    }

    public static double getWaterFireDelay() {
        return waterFireDelay;
    }

    public static double getEarthFireDelay() {
        return earthFireDelay;
    }

    public static double getAirAttackSpeedBoost() {
        return airAttackSpeedBoost;
    }

    public static double getAirRangeBoost() {
        return airRangeBoost;
    }
}
