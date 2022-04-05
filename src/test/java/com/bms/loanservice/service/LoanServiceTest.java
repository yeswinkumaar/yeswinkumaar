package com.bms.loanservice.service;

import com.bms.loanservice.entity.LoanDetail;
import com.bms.loanservice.entity.LoanTypeMaster;
import com.bms.loanservice.repository.LoanDetailRepository;
import com.bms.loanservice.service.impl.LoanServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {

    @InjectMocks
    LoanServiceImpl loanService;

    @Mock
    LoanDetailRepository dao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoanServiceFindByIdAndCreatedBy() throws Exception{
        LoanTypeMaster loanTypeMaster = new LoanTypeMaster(1,"PL");
        LoanDetail LOAN_DETAIL2 = new LoanDetail(2L,loanTypeMaster,122.22,new Date(),10.12,12);
        LOAN_DETAIL2.setCreatedBy("sjain");
        given(dao.findByIdAndCreatedBy(2L,"sjain")).willReturn(Arrays.asList(LOAN_DETAIL2));
        List<LoanDetail> loanDetailsData = loanService.getLoans(2L,1,10,"id","desc");
        assertEquals(1,loanDetailsData.size());
    }


    @Test
    public void testLoanIdNotExistAndCreatedBy() throws Exception{

        LoanTypeMaster loanTypeMaster = new LoanTypeMaster(1,"PL");
        LoanDetail LOAN_DETAIL2 = new LoanDetail(2L,loanTypeMaster,122.22,new Date(),10.12,12);
        LOAN_DETAIL2.setCreatedBy("sjain");

        given(dao.findByIdAndCreatedBy(1L,null)).willReturn(Arrays.asList(LOAN_DETAIL2));

        List<LoanDetail> loanDetailsData = loanService.getLoans(2L,1,10,"id","desc");

        assertEquals(0,loanDetailsData.size());

    }

}
