package com.cybersoft.uniclub.service;

import com.cybersoft.uniclub.entity.ProductDetailEnity;
import com.cybersoft.uniclub.entity.ProductEntity;
import com.cybersoft.uniclub.entity.key.ProductDetailId;
import com.cybersoft.uniclub.payload.request.InsertProductRequest;
import com.cybersoft.uniclub.repository.ProductDetailRepository;
import com.cybersoft.uniclub.repository.ProductRepository;
import com.cybersoft.uniclub.service.imp.FileServiceImp;
import com.cybersoft.uniclub.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private FileServiceImp fileServiceImp;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean insertProduct(InsertProductRequest productRequest) {
        boolean isSuccess = false; // Declare isSuccess as a local variable

        fileServiceImp.saveFile(productRequest.getFile());

        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductName(productRequest.getProductName());
            productEntity.setPrice(productRequest.getPrice());
            productEntity.setImage(productRequest.getFile().getOriginalFilename());
            productRepository.save(productEntity);

            // Them tiep du lieu vao bang product detail
            ProductDetailEnity productDetailEnity = new ProductDetailEnity();
            ProductDetailId id = new ProductDetailId();
            id.setIdProduct(productEntity.getIdProduct());
            id.setIdCategory(productRequest.getIdCategory());
            id.setIdTag(productRequest.getIdTag());
            id.setIdSize(productRequest.getIdSize());
            id.setIdColor(productRequest.getIdColor());

            productDetailEnity.setId(id);
            productDetailEnity.setSoLuong(productRequest.getSoLuong());
            productDetailRepository.save(productDetailEnity);

            System.out.println("ID sp: " + productEntity.getIdProduct());
            isSuccess = true;
        } catch (Exception e) {
            System.out.println("Kiem tra " + e.getMessage());
        }
        return isSuccess;
    }
}
