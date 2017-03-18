package owen.weidian.controller;

import com.weidian.open.sdk.AbstractWeidianClient;
import com.weidian.open.sdk.DefaultWeidianClient;
import com.weidian.open.sdk.exception.OpenException;
import com.weidian.open.sdk.http.Param;
import com.weidian.open.sdk.util.JsonUtils;
import com.weidian.open.sdk.util.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import owen.weidian.param.ItemAdd;
import owen.weidian.util.WeidianUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by owen on 17/3/17.
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    private AbstractWeidianClient client = DefaultWeidianClient.getInstance();

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String vdianItemGet(@RequestParam(value = "itemid") String itemid) throws OpenException {
        Map<String, Object> map = new HashMap<>();
        map.put("itemid", itemid);
        WeidianUtil.removeNullValue(map);
        return client.executePostForString(SystemConfig.API_URL_FOR_POST,
                new Param(SystemConfig.PUBLIC_PARAM, WeidianUtil.buildPublicValue("vdian.item.get", "1.0")),
                new Param(SystemConfig.BIZ_PARAM, JsonUtils.toJson(map)));
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String vdianItemAdd(ItemAdd item, @RequestParam(value = "titles[]") String[] titles, @RequestParam(value = "bigImgs[]") String[] bigImgs) throws OpenException {
        Map< String, Object> map = new HashMap<>();
        map.put("remote_free_delivery", null);
        map.put("titles", titles);
        map.put("stock", item.getStock());
        map.put("item_comment", item.getItemName());
        map.put("merchant_code", null);
        map.put("bigImgs", bigImgs);
        map.put("status", item.getStatus());
        map.put("free_delivery", item.getFreeDeliverly());
        map.put("sku", new ArrayList());
        map.put("price", item.getPrice());
        map.put("attr_list", new ArrayList());
        map.put("itemName", item.getItemName());
        WeidianUtil.removeNullValue(map);
        return client.executePostForString(SystemConfig.API_URL_FOR_POST,
                new Param(SystemConfig.PUBLIC_PARAM, WeidianUtil.buildPublicValue("vdian.item.add", "1.2")),
                new Param(SystemConfig.BIZ_PARAM, JsonUtils.toJson(map)));
    }
}
