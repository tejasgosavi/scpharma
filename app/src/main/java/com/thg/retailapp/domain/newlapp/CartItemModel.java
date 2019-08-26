package com.thg.retailapp.domain.newlapp;

public class CartItemModel {
    public static final int CART_ITEM=0;
    public static final int TOTAL_AMOUNT=1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    /////// cart item
    private int productImage;
    private String productTitle;
    private String productPrice;
    private String cuttedPrice;;
    private int productQuantity;
    private String productMargin;


    public CartItemModel(int type, int productImage, String productTitle, String productPrice, String cuttedPrice, int productQuantity, String productMargin) {
        this.type = type;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.productQuantity = productQuantity;
        this.productMargin = productMargin;
    }


    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductMargin() {
        return productMargin;
    }

    public void setProductMargin(String productMargin) {
        this.productMargin = productMargin;
    }

    //////// cart item

    /////// cart total

    private String totalItemPrice;
    private String totalAmount;
    private String deliveryPrice;
    private String savedAmount;
    private String totalItems;

    public CartItemModel(int type, String totalItemPrice, String totalItems, String deliveryPrice, String totalAmount, String savedAmount) {
        this.type = type;
        this.totalItemPrice = totalItemPrice;
        this.totalItems = totalItems;
        this.totalAmount = totalAmount;
        this.deliveryPrice = deliveryPrice;
        this.savedAmount = savedAmount;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(String savedAmount) {
        this.savedAmount = savedAmount;
    }
    ////// cart total
}
