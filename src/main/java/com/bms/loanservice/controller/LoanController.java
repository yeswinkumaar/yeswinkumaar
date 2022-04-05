package com.bms.loanservice.controller;

import com.bms.loanservice.common.APIResponse;
import com.bms.loanservice.entity.LoanDetail;
import com.bms.loanservice.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(LoanController.ENDPOINT)
public class LoanController {

    public static final String ENDPOINT = "api/v1/loan";


    private final LoanService loanService;


    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @GetMapping(
            value = "/view",
          
           produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<APIResponse> viewLoans(@RequestParam(name = "id",defaultValue = "0") Long id,
                                                 @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
                                                 @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                                 @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
                                                 @RequestParam(name = "sortOrder", defaultValue = "desc") String sortOrder,
                                                 @RequestHeader(name = "Auth_User") String username
    		){
    	APIResponse apiResponse;

        List<LoanDetail> loanDetails = loanService.getLoans(id,pageNo,pageSize,sortBy,sortOrder);
        if(loanDetails.isEmpty()){
            apiResponse = new APIResponse(HttpStatus.NOT_FOUND.value(), loanDetails,"NOT FOUND");
            return ResponseEntity
                    .status(apiResponse.getStatusCode())
                    .body(apiResponse);
        }

        apiResponse = new APIResponse(HttpStatus.OK.value(), loanDetails,"SUCCESS");
        return ResponseEntity
                .status(apiResponse.getStatusCode())
                .body(apiResponse);
        
    }


}
