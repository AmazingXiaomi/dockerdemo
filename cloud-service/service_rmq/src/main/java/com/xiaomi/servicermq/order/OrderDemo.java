package com.xiaomi.servicermq.order;

/**
 * @ClassName: OrderDemo
 * @author: xiaomi
 * @Description: //TODO
 * @Time: 2019/6/28 0028 下午 2:21
 * @email: a1205938863@gmail.com
 */
public class OrderDemo {
    private Long orderId;
    private String  desc;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "OrderDemo{" +
                "orderId=" + orderId +
                ", desc='" + desc + '\'' +
                '}';
    }
}
