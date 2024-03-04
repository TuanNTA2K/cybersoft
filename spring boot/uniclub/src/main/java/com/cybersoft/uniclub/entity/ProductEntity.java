package com.cybersoft.uniclub.entity;

import jakarta.persistence.*;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "ID_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private double price;
    @Column(name = "star")
    private int star;
    @Column(name = "description")
    private String description;
    @Column(name = "information")
    private String information;
    @Column(name = "sku")
    private String sku;
    @Column(name = "images")
    private String image;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
