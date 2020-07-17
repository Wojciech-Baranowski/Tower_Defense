package Game;

public class Stats
{
    public static int hp;
    public static int energy;
    public static int[] cost;
    public static int[] damage;
    public static int[] range;
    public static int[] bulletVelocity;
    public static double[] fireDelay;
    public static double[] attackSpeedBoost;
    public static double[] rangeBoost;
    public static double[] damageBoost;
    public static int[] splashRange;
    public static double[] splashDamage;
    public static double[] slow;
    public static double[] slowDuration;
    public static int[] dotaDamage;
    public static double[] dotaDuration;
    public static double[] armorPenetration;
    public static double[] snareDuration;
    public static double[] snareChance;
    public static double[] headshotChance;

    public Stats(int hp, int[] cost, int energy, int[] damage, int[] range, int[] bulletVelocity, double[] fireDelay, double[] attackSpeedBoost, double[] rangeBoost, double[] damageBoost, int[] splashRange, double[] splashDamage, double[] slow, double[] slowDuration, int[] dotaDamage, double[] dotaDuration, double[] armorPenetration, double[] snareDuration, double[] snareChance, double[] headshotChance)
    {
        this.hp = hp;
        this.energy = energy;
        this.cost = cost;
        this.damage = damage;
        this.range = range;
        this.bulletVelocity = bulletVelocity;
        this.fireDelay = fireDelay;
        this.attackSpeedBoost = attackSpeedBoost;
        this.rangeBoost = rangeBoost;
        this.damageBoost = damageBoost;
        this.splashRange = splashRange;
        this.splashDamage = splashDamage;
        this.slow = slow;
        this.slowDuration = slowDuration;
        this.dotaDamage = dotaDamage;
        this.dotaDuration = dotaDuration;
        this.armorPenetration = armorPenetration;
        this.snareDuration = snareDuration;
        this.snareChance = snareChance;
        this.headshotChance = headshotChance;
    }

    public static int getHp() {
        return hp;
    }

    public static int getEnergy() {
        return energy;
    }

    public static int[] getCost() {
        return cost;
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

    public static double[] getAttackSpeedBoost() {
        return attackSpeedBoost;
    }

    public static double[] getRangeBoost() {
        return rangeBoost;
    }

    public static double[] getDamageBoost() {
        return damageBoost;
    }

    public static int[] getSplashRange() {
        return splashRange;
    }

    public static double[] getSplashDamage() {
        return splashDamage;
    }

    public static double[] getSlow() {
        return slow;
    }

    public static double[] getSlowDuration() {
        return slowDuration;
    }

    public static int[] getDotaDamage() {
        return dotaDamage;
    }

    public static double[] getDotaDuration() {
        return dotaDuration;
    }

    public static double[] getArmorPenetration() {
        return armorPenetration;
    }

    public static double[] getSnareDuration() {
        return snareDuration;
    }

    public static double[] getSnareChance() {
        return snareChance;
    }

    public static double[] getHeadshotChance() {
        return headshotChance;
    }
}
