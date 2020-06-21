package Game;

public class Prices
{
    public static int[] basicPrices;
    public static int[] advancedPrices;
    public static int[] masterPrices;

    public Prices(int[] basicPrices, int[] advancedPrices, int[] masterPrices)
    {
        this.basicPrices = basicPrices;
        this.advancedPrices = advancedPrices;
        this.masterPrices = masterPrices;
    }

    public int[] getBasicPrices() {
        return basicPrices;
    }

    public static int[] getAdvancedPrices() {
        return advancedPrices;
    }

    public static int[] getMasterPrices() {
        return masterPrices;
    }
}
