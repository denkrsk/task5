package com.example.demotest.repository;

import com.example.demotest.model.Account_pool;
import com.example.demotest.model.Tpp_product_register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Account_poolRepository extends JpaRepository<Account_pool,Long> {
    @Query("select e from Account_pool e where e.branchCode = :branchCode and e.currencyCode = :currencyCode and e.priorityCode = :priorityCode and e.registryTypeCode = :registryTypeCode")
    List<Account_pool> findAcc(@Param("branchCode") String branchCode, @Param("currencyCode") String currencyCode, @Param("priorityCode") String priorityCode, @Param("registryTypeCode") String registryTypeCode);
}
