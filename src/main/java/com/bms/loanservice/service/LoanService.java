package com.bms.loanservice.service;

import com.bms.loanservice.entity.LoanDetail;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface LoanService {

    List<LoanDetail> getLoans(Long id, int pageNo, int pageSize, String sortBy, String sortOrder);

    List<LoanDetail> findAll();
}
