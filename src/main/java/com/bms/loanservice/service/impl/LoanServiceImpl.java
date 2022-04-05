package com.bms.loanservice.service.impl;


import com.bms.loanservice.entity.LoanDetail;
import com.bms.loanservice.entity.LoanTypeMaster;
import com.bms.loanservice.repository.LoanDetailRepository;
import com.bms.loanservice.repository.LoanTypeRepository;
import com.bms.loanservice.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Component
public class LoanServiceImpl implements LoanService {

   @Autowired
   private HttpServletRequest request;

    @Autowired
    private  LoanDetailRepository loanDetailRepository;

    @Autowired
    private  LoanTypeRepository loanTypeRepository;

    String name1="sjain";
    String name2="yeswin";

    public LoanServiceImpl() {
        super();
    }



    @PostConstruct
//    @Profile("test")
    public void postConstruct(){
    	
        LoanTypeMaster loanTypeMaster = new LoanTypeMaster("PL");
        loanTypeMaster.setCreatedBy(name1);
        loanTypeMaster.setCreatedDate(new Date());
        loanTypeRepository.save(loanTypeMaster);
        LoanDetail loanDetail = new LoanDetail(loanTypeMaster,122.22,new Date(),10.2,2);
        loanDetail.setCreatedBy(name1);
        loanDetail.setCreatedDate(new Date());
        
        LoanTypeMaster loanTypeMaster1 = new LoanTypeMaster("HL");
        loanTypeMaster1.setCreatedBy(name2);
        loanTypeMaster1.setCreatedDate(new Date());
        loanTypeRepository.save(loanTypeMaster1);
        LoanDetail loanDetail1 = new LoanDetail(loanTypeMaster1,102.22,new Date(),5.2,1);
        loanDetail1.setCreatedBy(name2);
        loanDetail1.setCreatedDate(new Date());
        LoanDetail loanDetail2 = new LoanDetail(loanTypeMaster,105.22,new Date(),5.2,1);
        loanDetail2.setCreatedBy(name2);
        loanDetail2.setCreatedDate(new Date());
        
        loanDetailRepository.saveAll(Arrays.asList(loanDetail,loanDetail1,loanDetail2));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LoanDetail> getLoans(Long id, int pageNo, int pageSize, String sortBy, String sortOrder) {

    	String userName=request.getHeader("Auth_User");
    	
        List<LoanDetail> loanDetails;

        Pageable pageable = null;

        if(id<=0) {

            if (sortOrder.equalsIgnoreCase("asc")) {
                pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Order.by(sortBy)).ascending());
            }

            else {
                pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Order.by(sortBy)).descending());
            }

            loanDetails = loanDetailRepository.findAllByCreatedBy(userName, pageable);

        }

        else{
            loanDetails = loanDetailRepository.findByIdAndCreatedBy(id,userName);

        }

        return loanDetails;
    }

    @Override
    public List<LoanDetail> findAll() {
        return loanDetailRepository.findAll();
        
    }
}
