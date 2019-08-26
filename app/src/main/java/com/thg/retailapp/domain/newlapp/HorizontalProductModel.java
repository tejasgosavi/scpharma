package com.thg.retailapp.domain.newlapp;

public class HorizontalProductModel {
    private int produceImage;
    private String productTitle;
    private String productDescription;
    private String productPrice;

    public int getProduceImage() {
        return produceImage;
    }

    public void setProduceImage(int produceImage) {
        this.produceImage = produceImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public HorizontalProductModel(int produceImage, String productTitle, String productDescription, String productPrice) {
        this.produceImage = produceImage;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;


    }
}
