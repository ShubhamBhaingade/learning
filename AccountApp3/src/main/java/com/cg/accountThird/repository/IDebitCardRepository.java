package com.cg.accountThird.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.accountThird.entity.DebitCard;
@Repository
public interface IDebitCardRepository extends JpaRepository<DebitCard, Long> {

}
