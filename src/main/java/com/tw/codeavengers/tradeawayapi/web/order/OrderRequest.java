package com.tw.codeavengers.tradeawayapi.web.order;

public class OrderRequest {
    private String sellerName;
    private String buyerName;
    private Integer quantity;
    private String deliveryAddress;
    private String itemName;

    public OrderRequest(String sellerName, String buyerName, Integer quantity, String deliveryAddress, String itemName) {
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.quantity = quantity;
        this.deliveryAddress = deliveryAddress;
        this.itemName = itemName;
    }

    public OrderRequest() {
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderRequest that = (OrderRequest) o;

        if (sellerName != null ? !sellerName.equals(that.sellerName) : that.sellerName != null) return false;
        if (buyerName != null ? !buyerName.equals(that.buyerName) : that.buyerName != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (deliveryAddress != null ? !deliveryAddress.equals(that.deliveryAddress) : that.deliveryAddress != null)
            return false;
        return itemName != null ? itemName.equals(that.itemName) : that.itemName == null;
    }

    @Override
    public int hashCode() {
        int result = sellerName != null ? sellerName.hashCode() : 0;
        result = 31 * result + (buyerName != null ? buyerName.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        return result;
    }
}
