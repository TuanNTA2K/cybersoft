package com.cybersoft.uniclub.payload.request;

import org.springframework.web.multipart.MultipartFile;

public class InsertProductRequest {
    private MultipartFile file;
    private String productName;
    private double price;
    private int idTag;
    private int idCategory;
    private int idColor;
    private int idSize;
    private int soLuong;

    public InsertProductRequest() {
    }

    public InsertProductRequest(MultipartFile file, String productName, double price,
                                int idTag, int idCategory, int idColor, int idSize, int soLuong) {
        this.file = file;
        this.productName = productName;
        this.price = price;
        this.idTag = idTag;
        this.idCategory = idCategory;
        this.idColor = idColor;
        this.idSize = idSize;
        this.soLuong = soLuong;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
