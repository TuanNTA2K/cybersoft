package com.cybersoft.uniclub.repository;

import com.cybersoft.uniclub.entity.ProductDetailEnity;
import com.cybersoft.uniclub.entity.key.ProductDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEnity, ProductDetailId> {

}
