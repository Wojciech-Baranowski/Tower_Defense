package engine;
import Game.Level;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JSONReader {
    public static Level parseJSON(String json)
    {
        return  JSON.parseObject(json, Level.class);
    }

    public static String toJSON(Object object)
    {
        return JSON.toJSONString(object);
    }
}
