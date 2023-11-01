package com.cg.accountThird.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.accountThird.entity.Policy;
@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Integer> {

}
