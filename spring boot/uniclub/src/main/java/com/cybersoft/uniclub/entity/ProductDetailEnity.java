package com.cybersoft.uniclub.entity;

import com.cybersoft.uniclub.entity.key.ProductDetailId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity(name = "productdetail")
public class ProductDetailEnity {
    @EmbeddedId
    private ProductDetailId id;
    @Column(name = "Soluong")
    private int soLuong;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public ProductDetailId getId() {
        return id;
    }

    public void setId(ProductDetailId id) {
        this.id = id;
    }
}
