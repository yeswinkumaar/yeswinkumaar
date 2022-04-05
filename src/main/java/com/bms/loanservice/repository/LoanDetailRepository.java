package com.bms.loanservice.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.loanservice.entity.LoanDetail;

import java.util.List;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Long> {

    List<LoanDetail> findAllByCreatedBy(String createdBy, Pageable pageable);

    List<LoanDetail> findByIdAndCreatedBy(long id,String createdBy);

}
