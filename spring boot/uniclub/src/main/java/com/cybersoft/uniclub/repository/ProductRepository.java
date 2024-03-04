package com.cybersoft.uniclub.repository;

import com.cybersoft.uniclub.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
