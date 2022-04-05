package com.bms.loanservice.service;

import com.bms.loanservice.common.APIResponse;
import com.bms.loanservice.entity.LoanDetail;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoanControllerTest extends AbstractTest{

    private final String LOAN_ENDPOINT = "/api/v1/loan";

    private List<LoanDetail> loanDetails;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        loanDetails = new ArrayList<>();
    }

    @Test
    public void testAllAppliedLoanWithSuccessResponse() throws Exception {
        String uri = LOAN_ENDPOINT+"/view";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        APIResponse apiResponse = mapFromJson(content,APIResponse.class);
        loanDetails = (List<LoanDetail>) apiResponse.getData();
        assertTrue(loanDetails.size()>0);
    }

    @Test
    public void testAppliedLoanByIdWithSuccessResponse()throws Exception{
        String uri = LOAN_ENDPOINT+"/view";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                        .param("id","2")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        APIResponse apiResponse = mapFromJson(content,APIResponse.class);
        loanDetails = (List<LoanDetail>) apiResponse.getData();
        assertEquals(1,loanDetails.size());
    }

    @Test
    public void testNotFoundLoanResponse()throws Exception{
        String uri = LOAN_ENDPOINT+"/view";
        mvc.perform(MockMvcRequestBuilders.get(uri)
                         .param("id","833122")
                         .contentType(MediaType.APPLICATION_JSON_VALUE)
                 )
                 .andExpect(status().isNotFound());
    }


}
