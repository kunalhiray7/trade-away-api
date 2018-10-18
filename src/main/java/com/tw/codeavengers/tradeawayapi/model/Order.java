package com.tw.codeavengers.tradeawayapi.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "item_order")
public class Order {
    @Id
    @Column(name = "order_id")
    private String orderId = UUID.randomUUID().toString();

    @Column(name = "seller_id")
    private String sellerId;

    @Column(name = "buyer_id")
    private String buyerId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "order_time")
    private Date orderTime;

    public Order() {
    }

    public Order(String sellerId, String buyerId, Integer quantity, String itemName, String deliveryAddress, Date orderTime) {

        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.quantity = quantity;
        this.itemName = itemName;
        this.deliveryAddress = deliveryAddress;
        this.orderTime = orderTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (sellerId != null ? !sellerId.equals(order.sellerId) : order.sellerId != null) return false;
        if (buyerId != null ? !buyerId.equals(order.buyerId) : order.buyerId != null) return false;
        if (quantity != null ? !quantity.equals(order.quantity) : order.quantity != null) return false;
        return itemName != null ? itemName.equals(order.itemName) : order.itemName == null;
    }

    @Override
    public int hashCode() {
        int result = sellerId != null ? sellerId.hashCode() : 0;
        result = 31 * result + (buyerId != null ? buyerId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        return result;
    }
}
