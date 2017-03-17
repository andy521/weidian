package owen.weidian.controller;

import com.weidian.open.sdk.AbstractWeidianClient;
import com.weidian.open.sdk.DefaultWeidianClient;
import com.weidian.open.sdk.exception.OpenException;
import com.weidian.open.sdk.http.Param;
import com.weidian.open.sdk.request.AbstractCommonRequest;
import com.weidian.open.sdk.util.JsonUtils;
import com.weidian.open.sdk.util.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import owen.weidian.param.ItemAdd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by owen on 17/3/17.
 */
@Controller
@RequestMapping("/item")
public class ItemController extends AbstractCommonRequest{

    private AbstractWeidianClient client = DefaultWeidianClient.getInstance();


    public ItemController() {
        super("4d0300c56164d05f45697673258edd76000673464d");
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String vdianItemAdd(ItemAdd item, @RequestParam(value = "titles[]") String[] titles,@RequestParam(value = "bigImgs[]") String[] bigImgs) throws OpenException {
        Map< String, Object> map = new HashMap< String, Object>();
//        map.put("remote_free_delivery", remote_free_delivery);
        map.put("titles", titles);
        map.put("stock", item.getStock());
//        map.put("item_comment", item_comment);
//        map.put("merchant_code", merchant_code);
        map.put("bigImgs", bigImgs);
        map.put("status", item.getStatus());
        map.put("free_delivery", item.getFreeDeliverly());
//        map.put("sku", sku);
        map.put("price", item.getPrice());
//        map.put("attr_list", attr_list);
        map.put("item_name", item.getItemName());
        super.removeNullValue(map);
        return client.executePostForString(SystemConfig.API_URL_FOR_POST,
                new Param(SystemConfig.PUBLIC_PARAM, buildPublicValue("vdian.item.add", "1.2")),
                new Param(SystemConfig.BIZ_PARAM, JsonUtils.toJson(map)));
    }
}
