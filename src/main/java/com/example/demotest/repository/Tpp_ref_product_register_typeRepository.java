package com.example.demotest.repository;

import com.example.demotest.model.Tpp_product_register;
import com.example.demotest.model.Tpp_ref_product_register_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tpp_ref_product_register_typeRepository  extends JpaRepository<Tpp_ref_product_register_type,Long> {
    Optional<Tpp_ref_product_register_type> findByValue(String value);

    @Query("select p from Tpp_ref_product_register_type p where p.product_class_code = :type")
    List<Tpp_ref_product_register_type> findprt_Acctype(@Param("type") String type);
}
