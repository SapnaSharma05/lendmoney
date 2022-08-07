package com.fourfinance.loan.sample.lendmoney.service;


import com.fourfinance.loan.sample.lendmoney.model.LoanHistoryResponse;
import com.fourfinance.loan.sample.lendmoney.model.LoanRequest;
import com.fourfinance.loan.sample.lendmoney.model.LoanResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static java.lang.System.out;

@Service
@AllArgsConstructor
public class LoanProcessingService {

    private final Integer MAX_POSSIBLE_AMOUNT = 5000;
    //private final LoanApplicationDao loanApplicationDao;

    public LoanResponse processLoanRequest(LoanRequest loanRequest, String remoteAddr){
        System.out.println("IP address "+remoteAddr);
        boolean isHighRisk = performRiskAnalysis(loanRequest.getLoanAmount());
        if(isHighRisk) {
            return LoanResponse.builder().referenceId("test").loanApplicationStatus("Rejected").build();
        }

        return new LoanResponse();

    }

    public boolean performRiskAnalysis(Integer amount) {
        LocalTime rangeStart = LocalTime.parse("00:00:00");
        LocalTime rangeEnd = LocalTime.parse("06:00:00");
        if ((LocalTime.now().isAfter(rangeStart) && LocalTime.now().isBefore(rangeEnd))
                && (amount > MAX_POSSIBLE_AMOUNT)) {
            out.println("HighRisk");
            return true;
        }
        return false;
    }

    public LoanHistoryResponse getLoanHistory(){
        return new LoanHistoryResponse();
    }

    public LoanResponse postponeLoanRequest(){
        return new LoanResponse();
    }

    /*public static void main(String args[]){
        LoanProcessingService lps = new LoanProcessingService();
        out.println(""+lps.performRiskAnalysis(5001));
    }*/
}
