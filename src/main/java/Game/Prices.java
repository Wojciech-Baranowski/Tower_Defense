package Game;

public class Prices
{
    public static int[] basicPrices;
    public static int[] advancedPrices;

    public Prices(int[] basicPrices, int[] advancedPrices)
    {
        this.basicPrices = basicPrices;
        this.advancedPrices = advancedPrices;
    }

    public int[] getBasicPrices() {
        return basicPrices;
    }

    public static int[] getAdvancedPrices() {
        return advancedPrices;
    }
}
