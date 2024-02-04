package com.example.demotest.repository;

import com.example.demotest.model.Tpp_product_register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tpp_product_registerRepository extends JpaRepository<Tpp_product_register,Long> {
    Optional<Tpp_product_register> findById(Long Id);

    @Query("select pp_product_register from Tpp_product_register pp_product_register where pp_product_register.product_id = :product_id and pp_product_register.type = :type")
    List<Tpp_product_register> findEmployeesWithMoreThanSalary(@Param("product_id") Long product_id, @Param("type") String type);
}
