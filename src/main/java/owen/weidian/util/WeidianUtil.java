package owen.weidian.util;

import com.weidian.open.sdk.exception.OpenException;
import com.weidian.open.sdk.util.JsonUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by owen on 17/3/18.
 */
public class WeidianUtil {
    public static  Map<String, Object> removeNullValue(Map<String, Object> map) {
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            if(entry.getValue() == null) {
                it.remove();
            }
        }
        return map;
    }

    public static String buildPublicValue(String method, String version, String format) throws OpenException {
        Map<String, String> map = new HashMap<String, String>(8);
        map.put("method", method);
        map.put("access_token", "4cd6c13e0a3e995447aca70b6d77550a000673464d");
        map.put("version", version);
        map.put("format", format);
        map.put("lang", "java");
        return JsonUtils.toJson(map);
    }

    public static  String buildPublicValue(String method, String version) throws OpenException {
        return buildPublicValue(method, version, "json");
    }
}
