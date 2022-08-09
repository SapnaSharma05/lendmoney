package com.fourfinance.loan.sample.lendmoney.controller;

import com.fourfinance.loan.sample.lendmoney.model.LoanHistoryResponse;
import com.fourfinance.loan.sample.lendmoney.model.LoanRequest;
import com.fourfinance.loan.sample.lendmoney.service.LoanProcessingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LoanProcessingControllerTest {

    public static final String IP_ADDRESS = "192.12.09.101";
    private final LoanProcessingService loanProcessingService = Mockito
            .mock(LoanProcessingService.class);
    private final HttpServletRequest requestMock = Mockito.mock(HttpServletRequest.class);
    private final LoanProcessingController loanProcessingController = new LoanProcessingController(loanProcessingService);

    @DisplayName("Test for successful loan application")
    @Test
    public void testSuccessLoanApplication(){
        when(requestMock.getHeader(any())).thenReturn(IP_ADDRESS);
        ResponseEntity<Object> responseEntity = loanProcessingController.loanApplicationRequest(LoanRequestTestData(),requestMock);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @DisplayName("Test for successful loan extension")
    @Test
    public void testSuccessLoanExtension(){
        ResponseEntity<Object> responseEntity = loanProcessingController.loanPostponeRequest(39);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @DisplayName("Test to get the loan history")
    @Test
    public void testLoanHistoryRetrieve(){
        ResponseEntity<Object> responseEntity = loanProcessingController.getLoanHistory("1337438");
        List<LoanHistoryResponse> body = (List<LoanHistoryResponse>) responseEntity.getBody();
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    public LoanRequest LoanRequestTestData(){
        return LoanRequest.builder().applicantName("Applicant Name")
                .loanTenure(3)
                .contactNumber("123456789")
                .employmentStatus("Employed")
                .taxPayerId("63927459")
                .gender("Male")
                .emailAddress("abc@gmail.com")
                .loanAmount(25000)
                .applicantDateOfBirth("09/08/2022")
                .noOfDependants(2)
                .dueDate(new Date())
                .build();
    }
}
