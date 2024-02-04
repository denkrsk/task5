package com.example.demotest.repository;

import com.example.demotest.model.Tpp_product;
import com.example.demotest.model.Tpp_ref_product_register_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Tpp_productRepository extends JpaRepository<Tpp_product,Long> {
    Optional<Tpp_product> findByNumber(String value);
}
