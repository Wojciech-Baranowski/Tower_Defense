package engine;
import Game.EnemyStats;
import Game.Level;
import Game.Stats;
import com.alibaba.fastjson.JSON;

public class JSONReader {
    public static Level parseJSONLevel(String json)
    {
        return  JSON.parseObject(json, Level.class);
    }
    public static Stats parseJSONStats(String json)
    {
        return  JSON.parseObject(json, Stats.class);
    }
    public static EnemyStats parseJSONEnemyStats(String json)
    {
        return  JSON.parseObject(json, EnemyStats.class);
    }
    public static String toJSON(Object object)
    {
        return JSON.toJSONString(object);
    }
}
