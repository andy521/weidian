package owen.weidian.param;

import java.util.List;

/**
 * Created by owen on 17/3/17.
 */
public class ItemAdd {
    /*必须字段*/
//    private String[] titles[]; //图片描述组
    private Integer stock; //库存量
//    private String[] bigImgs[]; // 图片组
    private Integer status; // status=1或不传为在架商品，status=2为下架商品,4表示下架和在架商品
    private Integer freeDeliverly; //1包邮，0不包邮
    private Double price; //价格
    private String itemName; //商品名称

    public ItemAdd() {
    }


    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFreeDeliverly() {
        return freeDeliverly;
    }

    public void setFreeDeliverly(Integer freeDeliverly) {
        this.freeDeliverly = freeDeliverly;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
