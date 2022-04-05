package com.bms.loanservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.loanservice.entity.LoanTypeMaster;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanTypeMaster, Integer> {

}
