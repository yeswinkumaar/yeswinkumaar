//package com.bms.loanservice;
//
//import com.bms.loanservice.common.APIResponse;
//import com.bms.loanservice.controller.LoanController;
//import com.bms.loanservice.entity.LoanDetail;
//import com.bms.loanservice.entity.LoanTypeMaster;
//import com.bms.loanservice.repository.LoanDetailRepository;
//import com.bms.loanservice.service.LoanService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(controllers = LoanController.class)
//@ActiveProfiles("test")
//public class LoanControllerTest {
//
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    LoanService loanService;
//
//    @Test
//    public void getSuccessResult() throws Exception{
//
//        LoanTypeMaster loanTypeMaster = new LoanTypeMaster(1,"PL");
//        loanTypeMaster.setCreatedBy("sjain");
//        LoanDetail LOAN_DETAIL1 = new LoanDetail(1L,loanTypeMaster,122.22,new Date(),10.12,12);
//        LoanDetail LOAN_DETAIL2 = new LoanDetail(2L,loanTypeMaster,122.22,new Date(),10.12,12);
//        LOAN_DETAIL2.setCreatedBy("sjain");
//        LOAN_DETAIL1.setCreatedBy("sjain");
//
////        List<LoanDetail> l1 = mock(LoanDetailRepository.class).findByIdAndCreatedBy(1L,"sjain");
////        List<LoanDetail> loanDetails = new ArrayList<>(Arrays.asList(LOAN_DETAIL1,LOAN_DETAIL2));
//
//        when(loanService.getLoans(anyLong(),anyInt(),anyInt(),anyString(),anyString())).thenReturn(Arrays.asList(LOAN_DETAIL1));
//
//        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
//        map.add("id","0");
//        map.add("pageNo","1");
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/v1/loan/view")
//                        .params(map)
//                        .contentType(MediaType.APPLICATION_JSON))
//               .andExpect(status().isOk())
//               .andReturn();
//
//        List<LoanDetail> loanDetailsData = (List<LoanDetail>) mapper.readValue(result.getResponse().getContentAsString(), APIResponse.class).getData();
//        Assertions.assertEquals(1,loanDetailsData.size());
//    }
//
//}
