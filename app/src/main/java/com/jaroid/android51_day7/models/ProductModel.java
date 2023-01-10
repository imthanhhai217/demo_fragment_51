package com.jaroid.android51_day7.models;

import java.io.Serializable;

public class ProductModel implements Serializable {
    private int id;
    private String productName, productDetails;
    private double productPrice;
    private int productImage;
    private boolean isSelected;

    public ProductModel(int id, String productName, String productDetails, double productPrice, int productImage) {
        this.id = id;
        this.productName = productName;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productName='" + productName + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", productPrice=" + productPrice +
                ", productImage=" + productImage +
                '}';
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
