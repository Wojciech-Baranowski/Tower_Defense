package engine;
import Game.Level;
import Game.Prices;
import Game.Stats;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONReader {
    public static Level parseJSONLevel(String json)
    {
        return  JSON.parseObject(json, Level.class);
    }
    public static Prices parseJSONPrices(String json)
    {
        return  JSON.parseObject(json, Prices.class);
    }
    public static Stats parseJSOStats(String json)
    {
        return  JSON.parseObject(json, Stats.class);
    }
    public static String toJSON(Object object)
    {
        return JSON.toJSONString(object);
    }
}
